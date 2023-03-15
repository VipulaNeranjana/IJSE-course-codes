package lk.ijse.dep10;

import com.microsoft.dbms.SQLServer;
import com.mysql.dbms.MYSQLServer;
import com.oracal.dbms.OracleServer;
import jdbc.JdbcApi;

public class ClientApp {
    public static void main(String[] args) {
        JdbcApi mysqlServer = new MYSQLServer();
        String response = mysqlServer.execute("hello");
        System.out.println(response);

//        OracleServer oracleServer = new OracleServer();
//        String response = oracleServer.executeCommand("hello");
//        System.out.println(response);
//
//        MYSQLServer mysqlServer = new MYSQLServer();
//        byte[] byt = mysqlServer.run("hello");
//        response = new String(byt);
//        System.out.println(response);
//
//        SQLServer sqlServer = new SQLServer();
//        StringBuilder sb = sqlServer.interpret("hello".getBytes());
//        response = sb.toString();
//        System.out.println(response);

    }
}
