package lk.ijse.dep10.jdbc;

import java.sql.*;

public class ReadDataDemo {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hello","root","2273349@P");
            String sql = "SELECT * FROM Students";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
//            resultSet.next();

            int id = resultSet.getInt(1);
            System.out.println(id);
            id = resultSet.getInt("id");
            System.out.println(id);

            String firstName = resultSet.getString("first_name");
            System.out.println(firstName);

            String lastName = resultSet.getString(3);
            System.out.println(lastName);

            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String firstName1 = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                String dob = resultSet.getString("dob");

                System.out.printf("id : %s, first name : %s, second name : %s, address : %s, gender : %s, dob : %s \n",id1,firstName1,secondName,address,gender,dob);

            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
