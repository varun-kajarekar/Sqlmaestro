package com.sqlmaestro.sqlmaestro.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlmaestro.sqlmaestro.entity.QueryRequest;
import com.sqlmaestro.sqlmaestro.service.SqlQueryService;

import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin()
@RestController
@RequestMapping("/api/v1")
public class SqlQueryConstroller {

    @Autowired
    SqlQueryService sqluqeryservice;



    @GetMapping("/tablenames")
    public ResponseEntity<List<String>> getTableNames() {
        return sqluqeryservice.getTableNames();
    }

    @GetMapping("/alltables")
    public ResponseEntity<Map<String,List<Map<String, Object>>>> alltables(){
        return sqluqeryservice.GetAllTables();
    }

    @PostMapping("/runsql")
    public ResponseEntity<List<Map<String, Object>>> SqlQuery(@RequestBody QueryRequest queryRequest) {
        return sqluqeryservice.RunSqlQuery(queryRequest.getQuery());
    }



}
