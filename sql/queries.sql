-- Q1. : Patient’s ID, sex, AND date of birth4.
SELECT subject_id, sex, dob
FROM mimic2v26.d_patients
WHERE dob < '2521-12-07' AND dob > '2304-09-13';

-- Q2. : Count the number of patients in the database.
SELECT count(subject_id)
FROM mimic2v26.d_patients;

-- Q3. : Serum HCO3 Histogram.
SELECT bucket, count(*)
FROM ( SELECT width_bucket(valuenum, 0, 231, 231) AS bucket
  FROM mimic2v26.labevents
  WHERE itemid IN (50022, 50025, 50172)
) AS t
GROUP BY bucket;
-- ORDER BY bucket; TODO: Removed this since parser doesn't support it yet.

-- Q4. : Medicine doses WHERE medicines are in a set of twenty generic medicines5.
SELECT doses_per_24hrs, dose_val_rx
FROM mimic2v26.poe_order, mimic2v26.poe_med
WHERE mimic2v26.poe_order.poe_id = mimic2v26.poe_med.poe_id
AND LOWER(mimic2v26.poe_order.medication) LIKE '%insulin%'
AND LOWER(mimic2v26.poe_med.drug_name_generic) LIKE '%insulin%'
GROUP BY doses_per_24hrs, dose_val_rx;

-- Q5. : Find the first ICU admission.
SELECT *
FROM (
  SELECT MIN(intime) OVER (PARTITION BY subject_id) AS min_intime, ie.*
  FROM mimic2v26.icustayevents ie
  WHERE DATE(outtime) - DATE(intime) >= 0
AND DATE(outtime) - DATE(intime) <= 3 ) AS t
WHERE min_intime = intime;

-- Q6. : Count the number of caregivers involved in the treatment of each patient for
-- caregivers WHERE the count of distinct caretakers is with a certain range.
SELECT subject_id, count(cgid)
FROM (
SELECT subject_id, cgid
FROM mimic2v26.chartevents
WHERE subject_id > 180 AND subject_id < 2000
GROUP BY subject_id, cgid
) AS t
GROUP BY subject_id
HAVING count(cgid) >= 10 AND count(cgid) <= 200;
