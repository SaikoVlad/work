import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.multi.MultiLabelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class GUI extends JFrame {

    private JButton button = new JButton("Прогноз на сегодня");
    private JTextArea textArea = new JTextArea();

    GUI(){
        super("Погода Минск");
        this.setVisible(true);
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1));
        container.add(textArea);
        textArea.setLineWrap(true);
        container.add(button);
        button.addActionListener(new ButtonListener());


    }



    class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            textArea.setText(weather());
        }
    }

    private static String weather(){
        String url = "http://meteo.by/minsk/";
        String table = "table[class=t-weather]";
        String elementSring = "tr[class=time]";
        String result ="";
        try{
            result = Weather.getWeather(url,table,elementSring);
        }catch (UnknownHostException e){
            System.out.printf("Can't find %s address.Check internet connection.",url);
        }
        catch (Exception e) {
            System.out.println(e);
        }


        return result;
    }

}
