select *
from R NATURAL INNER JOIN S ON R.A = S.B
where R.A <> 10
GROUP By R.A;

SELECT subject_id, sex, dob
FROM mimic2v26.d_patients
WHERE dob < ‘2521_12_07’ AND dob > ‘2304_09_13’;

SELECT COUNT(*)
FROM mimic2v26.d_patients;

SELECT bucket, COUNT(*)
FROM ( SELECT width_bucket(valuenum, 0, 231, 231) AS bucket
    FROM mimic2v26.labevents
    WHERE itemid IN (50022, 50025, 50172)
    ￼￼￼￼￼￼)
GROUP BY bucket
ORDER BY bucket;

SELECT DISTINCT doses_per_24hrs, dose_val_rx
FROM mimic2v26.poe_order, mimic2v26.poe_med
WHERE mimic2v26.poe_order.poe_id = mimic2v26.poe_med.poe_id
AND LOWER(mimic2v26.poe_order.medication) LIKE ‘%insulin%’
AND LOWER(mimic2v26.poe_med.drug_name_generic) LIKE ‘%insulin%’;

SELECT *
FROM (
    SELECT MIN(intime) OVER (PARTITION BY subject_id) AS min_intime, ie.*
    FROM mimic2v26.icustayevents ie
    WHERE DATE(outtime) - DATE(intime) >= 0 AND DATE(outtime) - DATE(intime) <= 3
    )
WHERE min_intime = intime;

SELECT subject_id, COUNT(DISTINCT(cgid)) as num_caretakers
FROM mimic2v26.chartevents
WHERE subject_id > 180 AND subject_id < 2000
GROUP BY subject_id
HAVING num_caretakers >= 10 AND num_caretakers <= 200;
