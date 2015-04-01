package checker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

import relation.Relation;
import utils.MyLogger;
import experiment.Benchmarker;
import experiment.MyTimer;

/**
 * A modified ResultSet class that is used to return the answer to user queries
 * along with meta information about the evaluation of policies.
 * 
 * TODO: Make this implement the interface of ResultSet.
 * 
 * @author prasang
 * 
 */
public class ResultSetPlus {

	public Relation query = null;

	public ResultSet rSet = null;

	public ArrayList<Boolean> success = new ArrayList<Boolean>();

	private ArrayList<String> preTxEndCmds = new ArrayList<String>();
	private ArrayList<String> preTxCommitsCmds = new ArrayList<String>();

	private boolean txCommitted = false;
	private boolean txAborted = false;

	public ResultSetPlus(final Relation query) {
		this.query = query;
	}

	public final void addResultSet(final ResultSet rSet) throws SQLException {
		if (this.rSet != null) {
			MyLogger.getLog().warning("Overwriting an existing resultset.");
			this.rSet.close();
			this.rSet.getStatement().close();
		}
		this.rSet = rSet;
	}

	public final void addPolicyOutcome(final boolean outcome) {
		success.add(outcome);
	}

	public final boolean isCompliant() {
		ListIterator<Boolean> iterator = success.listIterator(success.size());
		while (iterator.hasPrevious())
			if (!iterator.previous())
				return false;
		return true;
	}

	public final void finalize() throws SQLException {
		this.close();
	}

	public final void close() throws SQLException {
		if (!txAborted && !txCommitted)
			throw new IllegalStateException(
					"A transaction has to be committed or aborted before the "
							+ "resultset can be closed.");
		if (rSet == null)
			return;
		if (!rSet.isClosed()) {
			if (rSet.getStatement() instanceof PreparedStatement)
				this.rSet.close();
			else
				rSet.getStatement().close();
		}
	}

	public final void toExecBeforeTxEnds(final String sql) {
		preTxEndCmds.add(sql);
	}

	private final void execBeforeTxEnds(Benchmarker exptNumber)
			throws SQLException {
		for (String sql : preTxEndCmds) {
			ResultSet rs = null;
			try {
				MyTimer commitTimer = new MyTimer();
				commitTimer.start();
				rs = DB.getDB().executeQuery(sql);
				commitTimer.end();
				exptNumber.add(sql, commitTimer.read());
			} finally {
				if (rs != null) {
					if (rs.getStatement() instanceof PreparedStatement)
						rs.close();
					else
						rs.getStatement().close();
				}
			}
		}
	}

	public final void abort(final Benchmarker exptNumber) throws SQLException {
		execBeforeTxEnds(exptNumber);
		MyTimer commitTimer = new MyTimer();
		commitTimer.start();
		DB.getDB().abortTransaction();
		commitTimer.end();
		exptNumber.add("abort", commitTimer.read());
		txAborted = true;
	}

	public final void commit(final Benchmarker exptNumber) throws SQLException {
		for (String sql : preTxCommitsCmds) {
			try {
				MyTimer commitTimer = new MyTimer();
				commitTimer.start();
				DB.getDB().executeUpdate(sql);
				commitTimer.end();
				exptNumber.add(sql, commitTimer.read());
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		execBeforeTxEnds(exptNumber);
		MyTimer commitTimer = new MyTimer();
		commitTimer.start();
		DB.getDB().commitTransaction();
		commitTimer.end();
		exptNumber.add("commit", commitTimer.read());
		txCommitted = true;
	}

	public final void preTxCommitCommands(final String command) {
		if (preTxCommitsCmds.contains(command))
			return;
		preTxCommitsCmds.add(command);
	}

}
