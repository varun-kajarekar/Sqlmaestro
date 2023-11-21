package com.sqlmaestro.sqlmaestro.repository;

import java.util.List;
import java.util.Map;

public interface SqlQueryRepo {

    List<Map<String, Object>> RunSqlNormalQuery(String query);

    int RunSqlExcuteQuery(String query);
    
}
