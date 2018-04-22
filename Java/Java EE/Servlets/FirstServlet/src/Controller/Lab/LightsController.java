package Controller.Lab;

import Model.entity.Garland;
import Model.entity.Lights;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/lab/newLight")
public class LightsController extends HttpServlet {
    @Override
    //    public Lights(double price, double weight, double size, int lifeTime, int usualTemp, int colorfulTemperature) {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        Enumeration<String> parameterNames = req.getParameterNames();
        String []mas = new String[7];
        int i = 0;
        while (parameterNames.hasMoreElements()){
            mas[i] = req.getParameter(parameterNames.nextElement());
            i++;
        }
        Lights lights;

        try{
            lights = new Lights(Double.parseDouble(mas[0]), Double.parseDouble(mas[0]), Double.parseDouble(mas[0]), (int)Double.parseDouble(mas[0]), (int) (Double.parseDouble(mas[0]) / 1), Integer.parseInt(mas[0]));
        }catch (NullPointerException e){
            lights = new Lights(2,2,2,2,2,2);
            writer.println("you skipped parameters for your object! That's why here is default params");

        }
        writer.println(lights.toString());


    }
}
