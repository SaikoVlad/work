package by.bntu.fitr.povt.view;

import by.bntu.fitr.povt.model.ButtonsListener;
import javax.swing.*;
import java.awt.*;


public class MainForm extends JFrame {

    private JPanel panel;
    private JTextField textField1;
    private JButton enterButton;
    private JTextField textField2;

    public MainForm() {
        super("Labs");
        ButtonsListener blogic = new ButtonsListener(textField1,textField2);
        this.pack();
        this.setSize(new Dimension(200,200));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.enterButton.addActionListener(blogic.az);
    }

}
