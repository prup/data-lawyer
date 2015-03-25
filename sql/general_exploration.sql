set search_path TO 'mimic2v26';

select * from additives;

select * from censusevents ;

select * from chartevents limit 10;

select * from comorbidity_scores  limit 10;

select * from d_chartitems ;

select * from d_chartitems_detail  ;

select * from d_codeditems   ;

-- "CL REDUC DISLOCATION NEC "

select * from d_ioitems   limit 10 ;

select * from deliveries    limit 10 ;

select * from demographic_detail     limit 10 ;

select * from icd9     limit 10 ; -- Good one. 313K rows.

-- "SINGLE LIVEBORN BORN IN HOSPITAL DELIVERED WITHOUT"

select * from labevents limit 10;

select * from noteevents  limit 10;

select * from poe_order    limit 10;