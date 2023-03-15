package com.oracal.dbms;

import jdbc.JdbcApi;

public class OracleServer implements JdbcApi {
    public String executeCommand(String msg) {
        return "Oracle server " + msg;
    }

    @Override
    public String execute(String msg) {
        return executeCommand(msg);
    }
}
