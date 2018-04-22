/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.HeadsOrTails;
import model.PerfectOrNo;
import model.Reversed;

/**
 *
 * @author prostrmk
 */
public class GUI extends JFrame {

    JButton button1, button2, button3, button4;
    JLabel label1;
    JLabel label;
    JTextField textField;
    ehandler ehandler = new ehandler();
    int i, j;

    public GUI() {
        super("Laba 6");
        setLayout(new FlowLayout());
        button1 = new JButton("Throw a coin");
        button2 = new JButton("Check for perfection");
        button3 = new JButton("Reverse your number");
        button4 = new JButton("Get four: ");
        label = new JLabel("");
        label1 = new JLabel("");
        textField = new JTextField("999");
        label = new JLabel("Result: ");
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(textField);
        add(label);
        add(label1);
        button1.addActionListener(ehandler);
        button2.addActionListener(ehandler);
        button3.addActionListener(ehandler);
        button4.addActionListener(ehandler);

    }

    public class ehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            i = Integer.parseInt(textField.getText());
            if (e.getSource() == button1) {
                int h = HeadsOrTails.getHeadResult(i);
                label.setText("Heads:" + h);
                label1.setText("Tails: " + (i - h));
            } else if (e.getSource() == button2) {
                label.setText("");
                label1.setText("" + PerfectOrNo.checkerForPerfection(i));
            } else if (e.getSource() == button3) {
                label.setText("");
                label1.setText("" + Reversed.reverser(i));
            } else if (e.getSource() == button4) {
                label.setText("");
                label1.setText("");
                
                

            }

        }

    }

}
