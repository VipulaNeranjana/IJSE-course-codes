package lk.ijse.dep10.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloMySQL {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hello", "root", "2273349@P");  /*jdbc:mysql = protocol*/
            System.out.println(connection);
            Statement statement = connection.createStatement();

            String insertSql = "INSERT INTO Students VALUES (6,'nuwan','ramindu','veyangoda','MALE','1996-06-29')";
            String updateSql = "UPDATE Students SET address='matara' WHERE id=6";
            String deleteSql = "DELETE FROM Students WHERE id=6";

            int affectedRows = statement.executeUpdate(deleteSql);
            System.out.println(affectedRows);
        } catch (SQLException e) {
            System.out.println("wade aul");
            e.printStackTrace();
        }
    }
}
