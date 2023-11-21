package com.sqlmaestro.sqlmaestro.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SqlQueryRepoImpl implements SqlQueryRepo {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Map<String, Object>> RunSqlNormalQuery(String query) {
        return jdbc.queryForList(query);
    }

    @Override
    public int RunSqlExcuteQuery(String query) {
        return jdbc.update(query);
    }

}
