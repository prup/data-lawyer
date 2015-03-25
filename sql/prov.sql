CREATE AGGREGATE prov(tid[]) (
    sfunc = array_cat,
    stype = tid[],
    initcond = '{}'
);

CREATE AGGREGATE prov(tid) (
    sfunc = array_append,
    stype = tid[],
    initcond = '{}'
);
