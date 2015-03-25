-- the inputs are in the order defined in the table.
CREATE FUNCTION insert_to_prov(int, text, text, tid[]) RETURNS void AS $$
    INSERT INTO mimic2v26.provenance
	(SELECT $1, $2, $3, prov_value
	FROM unnest($4) as prov_value
	)
$$ LANGUAGE SQL;

-- the inputs are in the order defined in the table.
CREATE FUNCTION get_prov_raw(int, text, text, tid[]) RETURNS TABLE(qid INT, otid text, irid text, itid TID) AS $$
	SELECT $1, $2, $3, prov_value
	FROM unnest($4) as prov_value
$$ LANGUAGE SQL;

-- the inputs are in the order defined in the table.
DROP FUNCTION IF EXISTS insert_to_prov_temp(int, text, text, tid[]);
CREATE FUNCTION insert_to_prov_temp(int, text, text, tid[]) RETURNS void AS $$

    INSERT INTO provenance_temp
	(SELECT $1, $2, $3, prov_value FROM unnest($4) as prov_value)

--    CREATE TEMP TABLE IF NOT EXISTS provenance_temp (qid INT, otid TEXT, irid TEXT, itid TID);
--    SELECT *
--    INTO TABLE provenance_temp
--    FROM (SELECT $1 qid, $2 otid, $3 irid, prov_value itid FROM unnest($4) as prov_value) as prov_result
$$ LANGUAGE SQL;

DROP FUNCTION IF EXISTS insert_to_prov_temp(int, text, text, tid[]); CREATE FUNCTION insert_to_prov_temp(int, text, text, tid[]) RETURNS void AS $$ INSERT INTO provenance_temp (SELECT $1, $2, $3, prov_value FROM unnest($4) as prov_value) $$ LANGUAGE SQL;
