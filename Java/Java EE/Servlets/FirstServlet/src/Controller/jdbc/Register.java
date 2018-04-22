package Controller.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/register")
public class Register extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (checkString(username.toCharArray())&&checkString(password.toCharArray())){
            String dbname = "root";
            String dbpassword =  "0";
            String connectionUrl = "jdbc:mysql://localhost:3306/userbase";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try(Connection connection = DriverManager.getConnection(connectionUrl,dbname,dbpassword)) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(String.format("INSERT INTO userbase.Base (name,password) VALUES ('%s','%s')",username,password));
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }


    private boolean checkString(char []mas){
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]==' '|| mas[i]=='_');
            return false;
        }
        return true;
    }

}
