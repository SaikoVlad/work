package Controller.Lab;

import Model.entity.Garland;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(value = "/lab/newGarland")
public class GarlandController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Enumeration<String> parameterNames = req.getParameterNames();
        String []mas = new String[7];
        int i = 0;
        while (parameterNames.hasMoreElements()){
            mas[i] = req.getParameter(parameterNames.nextElement());
            i++;
        }
        Garland garland;
        if (!mas[0].equals("")) {
            garland = new Garland(Double.parseDouble(mas[0]), Double.parseDouble(mas[0]), Double.parseDouble(mas[0]), Double.parseDouble(mas[0]), (int) (Double.parseDouble(mas[0]) / 1), mas[0]);
        }else{
            garland = new Garland(2,2,2,2,2,"star");
            writer.println("you skipped parameters for your object! That's why here is default params");
        }
        writer.println(garland.toString());

    }
}
