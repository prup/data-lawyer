set search_path to mimic2v26, public;

-- Not more than 200 tuples allowed on any query over the relation d_patients.
SELECT 'The query has cardinality: ' || count(t.otid) || ' for query: ' || t.qid
FROM (
SELECT p.qid, p.otid
FROM Schema s, Provenance p
WHERE s.irid = 'd_patients' AND s.qid = p.qid
GROUP BY p.qid, p.otid
) AS t
GROUP BY t.qid
HAVING COUNT(t.otid) > 200
;

-- poe_med can only join either with poe_order or itself.
SELECT *
FROM Schema l, Schema r
WHERE l.qid = r.qid AND l.irid = 'poe_med' AND
      r.irid <> 'poe_med' AND r.irid <> 'poe_order'
;

-- Only SELECT-COUNT queries are allowed and each count result must be at
-- least 10.
SELECT t.qid, t.otid
FROM (
SELECT p.qid, p.otid, p.itid
FROM Provenance p
WHERE p.irid = 'd_patients'
GROUP BY p.qid, p.otid, p.itid
) AS t
GROUP BY t.qid, t.otid
HAVING COUNT(t.itid) < 10
;

-- No query may access both the location data and the list of hobbies of the
-- same person in a social network dataset.
-- More concretely we need to check for queries where the output contains
-- tuples with both the (name, address) attribute and when the other relation
-- is queried with the output containing both the (ssn, address) attribute for
-- some tuple whose (name, address) attribute has been accessed before, do we
-- flag a violation.

-- TODO: Find a suitable table for this. d_patients is not good enough.  First
-- select row only select queries executed by this user.  Second select row
-- only selects queries over d_patients with name and address for the first
-- query and ssn and address for the second query.  Third select row only
-- select queries over d_patients with name and address for the first query
-- and ssn and address for the second query.  Finally, check if the same input
-- tuple has been revealed.
SELECT *
FROM
Users u1, Users u2, Schema s11,
Schema s12, Schema s21, Schema s22,
Provenance p1, Provenance p2
WHERE
u1.uid = u2.uid AND u1.qid = s11.qid AND
u1.qid = s12.qid AND u2.qid = s21.qid AND
u2.qid = s22.qid AND s11.irid = 'd_patients' AND
s11.icid = 'name' AND s12.irid = 'd_patients' AND
s12.icid = 'address' AND s11.agg = FALSE AND
s12.agg = FALSE AND s21.irid = 'd_patients' AND
s21.icid = 'ssn' AND s22.irid = 'd_patients' AND
s22.icid = 'address' AND s21.agg = FALSE AND
s22.agg = FALSE AND u1.qid = p1.qid AND
u2.qid = p2.qid AND p1.irid = 'd_patients' AND
p2.irid = 'd_patients' AND p1.itid = p2.itid
;

-- Each query on the dataset must include a certain column for all queries
-- executed on the dataset. The domain of this column in a single value.
-- TODO: This policy is clearly incrementally computable.
SELECT s.qid
FROM Schema s
WHERE s.irid = 'd_patients'
EXCEPT (
SELECT s.qid
FROM Schema s
WHERE s.irid = 'd_patients' AND
s.icid = 'copyright' AND s.agg = TRUE
)
;

-- Only 10 distinct users over the past four months.
SELECT 1
FROM (
SELECT u.uid
FROM Users u, Groups g, Clock c
WHERE u.uid = g.uid AND g.gid = 'uw' AND
u.ts <= c.ts AND u.ts > c.ts - 300
GROUP BY u.uid
) AS t
HAVING COUNT(t.uid) > 10
;

-- Only 50% of the dataset can be accessed in a span of a month.
SELECT t.total
FROM (
SELECT p.itid
FROM Provenance p, Users u
WHERE p.irid = 'd_patients' AND
u.uid = '1' AND u.qid = p.qid
GROUP BY p.itid
) as v,
(SELECT COUNT(*) as total
FROM d_patients
) as t
GROUP BY t.total
HAVING COUNT(v.itid) > t.total / 2
;

-- Rate throttling.
SELECT 1
FROM (
SELECT u.qid
FROM Users u, Clock c
WHERE u.uid = '1' AND u.ts <= c.ts
AND u.ts > c.ts - 100
GROUP BY u.qid
) AS t
HAVING COUNT(t.qid) > 100
;

-- Skew throttling.
SELECT p.itid
FROM Users u, Provenance p, Clock c
WHERE u.uid = '1' AND u.ts <= c.ts AND
u.ts > c.ts - 100 and u.qid = p.qid AND
p.irid = 'd_patients'
GROUP BY p.itid
HAVING COUNT(p.itid) > 10
;

-- TODO: No query must use a particular index and must not access more than
-- 100 tuples as input. For SLA enforcement.

-- Only allow 10 unsuccessful attempts in a day.
SELECT r.uid
FROM Rejects r, Clock c
WHERE r.ts <= c.ts AND r.ts > c.ts - 24
GROUP BY r.uid
HAVING COUNT(r.qid) > 10
;

-- If two applications access the same patients multiple times at close
-- intervals, prevent such access. For detecting out of eco-system data
-- merging.

-- Aren't all these CEP?

-- TODO: Adding the origins of output columns. Either they are aggregates or
-- not. Also, you must go through all joins and check the equality condition
-- and see which other columns are joined through this chaining.
