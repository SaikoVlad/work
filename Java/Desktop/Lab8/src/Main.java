public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(findSimpleDeviders(132, 2));
    }

    private static String findSimpleDeviders(int number, int iterator) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (number < 0){
            throw new Exception("Incorrect input");
        }
        if (number % iterator == 0 && number < iterator){

            sb.append(number).append(" ");
            sb.append(findSimpleDeviders(number/iterator, ++iterator));
        }

        return sb.toString();
    }
}
