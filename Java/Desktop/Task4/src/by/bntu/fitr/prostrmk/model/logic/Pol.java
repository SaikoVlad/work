package by.bntu.fitr.prostrmk.model.logic;

public class Pol {





    public static boolean compare(String in){
        if (in.equals(reverseString(in))){
            return true;
        }
        return false;
    }



    private static String reverseString(String in){
        char []temp = in.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length - 1; i >= 0 ; i--) {
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}
