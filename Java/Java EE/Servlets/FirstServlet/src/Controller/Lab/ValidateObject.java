package Controller.Lab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/lab/validateObject")
public class ValidateObject extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        String parameter = request.getParameter("objectSelector");
        if (parameter.equals("Stuffed toy")){
            response.sendRedirect("createStuffedToy.jsp");
        }else if (parameter.equals("Garland")){
            response.sendRedirect("createGarland.jsp");
        }else if(parameter.equals("Lights")){
            response.sendRedirect("createLights.jsp");
        }else{
            response.sendRedirect("../error.jsp");
        }
    }

}
