package com.sqlmaestro.sqlmaestro.service;

import java.util.List;
import java.util.Map;

public interface SqlQueryService {

    List<Map<String, Object>> RunSqlQuery(String query);

    List<Map<String, Object>> GetAllTables();
    
}
