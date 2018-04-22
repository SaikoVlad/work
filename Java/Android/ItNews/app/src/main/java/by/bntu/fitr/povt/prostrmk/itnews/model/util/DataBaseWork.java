package by.bntu.fitr.povt.prostrmk.itnews.model.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseWork {


    public static String getNews() {
        StringBuilder sb = new StringBuilder();
        String username = "root";
        String password =  "0";
        String connectionUrl = "jdbc:mysql://localhost:3306/ItNews";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            sb.append(e.toString());
        }
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('inferno')");
            statement.executeUpdate("INSERT INTO Books SET NAME = 'Solomon key'");
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM Articles ORDER BY id DESC LIMIT 2");
            while (resultSet.next()){
                sb.append(resultSet.toString());
//                System.out.println(String.format("ID: %d\tName: %s",resultSet.getInt("id"),resultSet.getString("name")));
            }
        } catch (SQLException e) {
            sb.append(e.toString());
        }
        return sb.toString();
    }

}
