package Controller.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet(urlPatterns = "/submit")
public class Auth extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ok = false;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String dbname = "root";
        String dbpassword =  "0";
        String connectionUrl = "jdbc:mysql://localhost:3306/userbase";
        try {
            Class.forName("com.mysql.jdbc.Driver"   );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(connectionUrl,dbname,dbpassword)) {
            Statement statement = connection.createStatement();
//            statement.executeUpdate(String.format("INSERT INTO userbase.Base VALUES ('%s','%s')",username,password));
            ResultSet resultSet = statement.executeQuery(String.format("SELECT %s FROM userbase.Base WHERE password='%s' AND name='%s'","name",password,username));
            String confuser;
            if (resultSet.next()){
                confuser = resultSet.getString("name");
            }else{
                confuser = "";
            }
            System.out.println(confuser);
            if (confuser.equals(username)){
                ok = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ok){
            req.authenticate(resp);
            resp.sendRedirect("mainPage.jsp");
        }else{
            resp.sendRedirect("invalidLogin.jsp");
        }
    }



}
