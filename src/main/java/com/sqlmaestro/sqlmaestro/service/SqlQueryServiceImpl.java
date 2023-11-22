package com.sqlmaestro.sqlmaestro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sqlmaestro.sqlmaestro.repository.SqlQueryRepo;

@Service
public class SqlQueryServiceImpl implements SqlQueryService {

    @Autowired
    SqlQueryRepo sqlqueryrepo;



    // This function run SQL queries
    @Override
    public ResponseEntity<List<Map<String, Object>>> RunSqlQuery(String query) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        try {

            if (CheckQueryType(query.toLowerCase())) {

                //Run the SELECT Query and store the data in 'result' List
                result = sqlqueryrepo.RunSqlNormalQuery(query);

                return new ResponseEntity<List<Map<String,Object>>>(result, HttpStatusCode.valueOf(200));

            } else {

                // To Run the insert, update or delete Query
                int QueryResult = sqlqueryrepo.RunSqlExcuteQuery(query);

                // Result
                map.put("column updated", QueryResult);
                result.add(map);
                return new ResponseEntity<List<Map<String,Object>>>(result, HttpStatusCode.valueOf(200));
            }

        } catch (Exception e) {
            map.put("Error msg", e.getMessage());
            result.add(map);
        }

        return new ResponseEntity<List<Map<String,Object>>>(result, HttpStatusCode.valueOf(400));
    }



    //With the help of this function ,we get all the tables preset in DB
    @Override
    public ResponseEntity<Map<String,List<Map<String, Object>>>> GetAllTables() {

        final String TABLES_NAME_QUERY = "SHOW TABLES;";

        // Get all the Table present in DB
        List<Map<String, Object>> TablesName = sqlqueryrepo.RunSqlNormalQuery(TABLES_NAME_QUERY);

        //Result
        Map<String,List<Map<String, Object>>> result = new HashMap<String,List<Map<String,Object>>>();


        for(Map<String, Object> mp : TablesName){

            // Extract the table name
            String TABLE_NAME = (String) mp.get("TABLE_NAME");

            
            String Query = "SELECT * FROM "+TABLE_NAME;

            // Get the data present in the table with the help of above query
            List<Map<String, Object>> TableData = sqlqueryrepo.RunSqlNormalQuery(Query);

            //Put Table name as well as table data as key , value pair
            result.put(TABLE_NAME, TableData);


        }

        // send the response
        return  new ResponseEntity<Map<String,List<Map<String, Object>>>>(result, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<String>> getTableNames() {

        final String TABLES_NAME_QUERY = "SHOW TABLES;";

        // Get all the Table present in DB
        List<Map<String, Object>> TablesName = sqlqueryrepo.RunSqlNormalQuery(TABLES_NAME_QUERY);

        List<String> result = new ArrayList<String>();

        for(Map<String, Object> mp : TablesName){

            // Extract the table name
            String TABLE_NAME = (String) mp.get("TABLE_NAME");

            result.add(TABLE_NAME);

        }
        return new ResponseEntity<List<String>>(result,HttpStatusCode.valueOf(200));
    }



    // To check Whether the query is 'SELECT' Query or not
    public static Boolean CheckQueryType(String query) {
        if (query.contains("select")) {
            return true;

        }
        return false;
    }



   

}
