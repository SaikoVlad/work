package prostmk.Model.Sql;

import java.sql.*;

public class SqLite {

    private static Connection conn;
    private static Statement statmt;
    private static ResultSet resSet;

    public static void Connection() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
        System.out.println("Database connected!");
    }
    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE IF NOT EXISTS 'users' (name text NOT NULL , password text NOT NULL);");

        System.out.println("Таблица создана или уже существует.");
//        return statmt;
    }
    public static void WriteDB(String name, String password) throws SQLException {
        statmt = conn.createStatement();
        statmt.execute(String.format("INSERT INTO 'users' ('name', 'password') VALUES ('%s', %s)",name,password));
        System.out.println("Таблица заполнена");
    }
    public static void ReadDB() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM users");
        while(resSet.next())
        {
//            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  password = resSet.getString("password");
            System.out.println( "name = " + name );
            System.out.println( "password = " + password );
            System.out.println();
        }
        System.out.println("Таблица выведена");
    }

}
