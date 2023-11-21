package com.sqlmaestro.sqlmaestro.entity;

public class QueryRequest {
    
    private String Query;

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public QueryRequest(String query) {
        Query = query;
    }

    public QueryRequest() {
    }

    @Override
    public String toString() {
        return "QueryRequest [Query=" + Query + "]";
    }
    
}
