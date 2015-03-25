-- select alias_1.cuid, alias_1.label, prov(alias_1.ctid) AS ctid_1
-- from	 mimic2v26.d_careunits as alias_1
-- group by alias_1.cuid, alias_1.label


-- select sum(alias_1.cuid), prov(alias_1.ctid) AS ctid_1
-- from	 mimic2v26.d_careunits as alias_1

SELECT insert_to_prov(1, md5(cast(alias__0.aggcol_1 as text)), 'mimic2v26.d_careunits', alias__0.ctid_1)
FROM (select sum(alias_1.cuid) AS aggcol_1, prov(alias_1.ctid) AS ctid_1
    from     mimic2v26.d_careunits as alias_1
) AS alias__0
