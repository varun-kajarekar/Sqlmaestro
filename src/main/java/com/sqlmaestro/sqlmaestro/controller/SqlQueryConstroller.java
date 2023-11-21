package com.sqlmaestro.sqlmaestro.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlmaestro.sqlmaestro.entity.QueryRequest;
import com.sqlmaestro.sqlmaestro.service.SqlQueryService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1")
public class SqlQueryConstroller {

    @Autowired
    SqlQueryService sqluqeryservice;

    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/alltables")
    public List<Map<String, Object>> alltables(){
        return sqluqeryservice.GetAllTables();
    }

    @PostMapping("/runsql")
    public List<Map<String, Object>> SqlQuery(@RequestBody QueryRequest queryRequest) {
        return sqluqeryservice.RunSqlQuery(queryRequest.getQuery());
    }

}
