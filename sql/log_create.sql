CREATE TABLE IF NOT EXISTS querylog (
    query_id	INT		PRIMARY KEY,
    user_id	INT,
    timestamp	LONG,
    query	VARCHAR(1000)
);
