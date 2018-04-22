package controller;

import java.util.Scanner;
import javax.swing.JFrame;
import view.*;
import model.*;

//Все норм, но надо еще дописать пару классов
public class Lab6 {

    public static void main(String[] args) {
//        mainMenu();
        guiCreator();
    }
    
    private static void guiCreator(){
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setSize(500, 200);
        
    }
    
    

    private static void mainMenu() {
        
        boolean work = true;
        String choise;
        int item;
        String again;
        Scanner scanner = new Scanner(System.in);
        while (work) {
            Out.line("Take a choise:\n1 - Throw a coin\n2 - Check number for perfection\n3 - Reverse your number\n4 - Numbers operations\n5 - Exit\n->");
            try {
                choise = scanner.next();
            } catch (Exception e) {
                Out.newline("Type error. Please, input integer.");
                continue;
            }
            switch (choise) {
                case "1":
                    Out.line("Input a limit for throwing: ");
                    item = integerChecker();
                    int head = HeadsOrTails.getHeadResult(item);
                    Out.newline("Heads: " + head);
                    Out.newline("Tails: " + (item - head));
                    break;
                case "2":
                    Out.line("Input a number for check: ");
                    item = integerChecker();
                    Out.newline("Result: " + PerfectOrNo.checkerForPerfection(item));
                    break;
                case "3":
                    Out.line("Input any number: ");
                    item = integerChecker();
                    Out.newline("Your reversed value: " + Reversed.reverser(item));
                    break;
                case "4":
                    fourthMenu();
                    break;
                case "5":
                    work = false;
                    break;
                default:
                    Out.newline("No matches!");
            }

        }//cycle

    }//menu

    private static void fourthMenu() {
        int item, item1;
        Out.line("\tChoose item of menu:\n\t1 - Sum And Quantity\n\t2 - Palindrom\n\t3 - Simple or not\n\t4 - Deviders\n\t5 - LCM and GCD finder\n\t6 - Max value\n\t-> ");
        int choise = integerChecker();
        switch (choise) {
            case 1:
                Out.line("\tType some integer: ");
                item = integerChecker();
                Out.newline("\tSum is : " + SumAndQuantity.sum(item));
                Out.newline("\tQuantity of numbers: " + SumAndQuantity.quantity(item));
                break;
            case 2:
                Out.line("\tIntput number: ");
                item = integerChecker();
                Out.newline("\tResult: " + Palindrom.getPalindrome(item));
                break;
            case 3:
                Out.line("\tInput your int value: ");
                item = integerChecker();
                Out.newline("\tResult is: " + SimpleOrNot.simpleOrNot(item));
                break;
            case 4:
                Out.line("\tInput your value: ");
                item = integerChecker();
                Out.newline("\tDividers for " + item + ": " + Dividers.deviders(item));
                break;
            case 5:
                Out.newline("\tType your numbers to find LCM and GCD: ");
                Out.line("\t1)");
                item = integerChecker();
                Out.line("\t2)");
                item1 = integerChecker();
                Out.newline("\tLCM: " + NodAndNokFinder.finderOfNok(item, item1));
                Out.newline("\tGCD: " + NodAndNokFinder.finderOfNod(item, item1));
                break;
            default:

                break;

        }

    }

    private static int integerChecker() {
        int i;
        try {
            i = Read.Integer();
        } catch (Exception e) {
            Out.newline("Type error. Please, input integer.");
            return -1;
        }
        return i;
    }

}
