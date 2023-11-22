package com.sqlmaestro.sqlmaestro.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface SqlQueryService {

    ResponseEntity<List<Map<String, Object>>> RunSqlQuery(String query);

    ResponseEntity<Map<String,List<Map<String, Object>>>> GetAllTables();

    ResponseEntity<List<String>> getTableNames();
    
}
