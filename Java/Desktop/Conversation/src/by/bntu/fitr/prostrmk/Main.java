package by.bntu.fitr.prostrmk;

import java.util.*;

public class Main {



    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 10; i+=2) {
            a.add(i);
        }
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 1; i < 10; i+=2) {
            b.add(i);
        }
        merge(a,b);

    }


    public static void merge(ArrayList firstlist, ArrayList secondlist){
        firstlist.addAll(secondlist);
        Collections.sort(firstlist);
        System.out.println(new StringBuilder().append("First list: ").append(firstlist).append("\nSecond list: ").append(secondlist));
    }


}

