package by.bntu.fitr.prostrmk.controller;

import by.bntu.fitr.prostrmk.model.collection.StackImpl;
import by.bntu.fitr.prostrmk.model.logic.Pol;
import by.bntu.fitr.prostrmk.view.Output;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        StackImpl <String> stringStack = new StackImpl<String>("uouou1", "asddsa", "uou", "lil", "peep");

//        while(!stringStack.isEmpty()){
//            Object o = stringStack.pop();
//            Output.print(String.format("%s - %s", o.toString(), Pol.compare(o.toString())));
//        }
//
//        StackImpl <Character> characterStack = new StackImpl<>();
//        characterStack.add('l');
//        characterStack.add('0');
//        characterStack.add('b');
//        Output.print(String.format("%s - %s", characterStack.toString(),));
    }
}
