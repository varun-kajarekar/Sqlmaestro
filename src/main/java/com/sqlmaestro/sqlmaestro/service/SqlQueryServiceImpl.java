package com.sqlmaestro.sqlmaestro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqlmaestro.sqlmaestro.repository.SqlQueryRepo;

@Service
public class SqlQueryServiceImpl implements SqlQueryService {

    @Autowired
    SqlQueryRepo sqlqueryrepo;

    @Override
    public List<Map<String, Object>> RunSqlQuery(String query) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        try {

            if (CheckQueryType(query.toLowerCase())) {

                // To Run the SELECT Query
                return sqlqueryrepo.RunSqlNormalQuery(query);

            } else {

                // To Run the insert, update or delete Query
                int QueryResult = sqlqueryrepo.RunSqlExcuteQuery(query);

                // Result
                map.put("column updated", QueryResult);
                result.add(map);
                return result;
            }

        } catch (Exception e) {
            map.put("Error msg", e.getMessage());
            result.add(map);
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> GetAllTables() {

        final String Query = "SHOW TABLES;";
        return sqlqueryrepo.RunSqlNormalQuery(Query);
    }

    // To check Whether the query is 'SELECT' or not
    public static Boolean CheckQueryType(String query) {
        if (query.contains("select")) {
            return true;

        }
        return false;
    }

}
