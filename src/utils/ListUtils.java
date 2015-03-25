package utils;

import java.util.List;

public class ListUtils {

	public static <T> void union(List<T> base, List<T> addition) {
		for (T o: addition)
			if (!base.contains(o))
				base.add(o);
	}
	
}
