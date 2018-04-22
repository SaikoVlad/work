package prostmk.Model.Sql;

import java.sql.*;

public class Jdbc {

    public static void example() throws ClassNotFoundException {
        String username = "root";
        String password =  "0";
        String connectionUrl = "jdbc:mysql://localhost:3306/testbase";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,username,password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR (30) NOT NULL, PRIMARY KEY (id))");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('inferno')");
            statement.executeUpdate("INSERT INTO Books SET NAME = 'Solomon key'");
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM Books");
            while (resultSet.next()){
                System.out.println(String.format("ID: %d\tName: %s",resultSet.getInt("id"),resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
