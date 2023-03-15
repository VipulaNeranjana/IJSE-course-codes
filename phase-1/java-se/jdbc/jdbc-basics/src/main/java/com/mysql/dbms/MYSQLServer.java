package com.mysql.dbms;

import jdbc.JdbcApi;

public class MYSQLServer implements JdbcApi {
    public byte[] run(String msg){
        return ("My SQL Server " + msg).getBytes();
    }

    @Override
    public String execute(String msg) {
        return new String(run(msg));
    }
}
