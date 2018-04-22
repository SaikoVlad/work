package model;

import java.util.Arrays;



public class MaxValue {
    
    public static char maxValue(String line) {

//        View.writeLine("\tInput number: ");
//        String line = Input.string();
        char[] massive = line.toCharArray();
        Arrays.sort(massive);

//        View.writeLine("\tMax value is: " + massive[massive.length - 1]);
        return massive[massive.length - 1];
    }
    
}
