package by.bntu.fitr.povt.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener {

    private JTextField textField1;
    private JTextField textField2;

    public ButtonsListener(JTextField textfield, JTextField textfield2){
        this.textField1 = textfield;
        this.textField2 = textfield2;
    }

    public ActionListener az = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("works");
            if (textField1 == null || textField2==null){
                JOptionPane.showMessageDialog(null,"Incorrect input");
            }else{
                WriteInFile.write(textField1.getText() + " Lab\t:\t " + textField2.getText() + " points\n");
                JOptionPane.showMessageDialog(null, "Successful write");
            }
        }
    };

}
