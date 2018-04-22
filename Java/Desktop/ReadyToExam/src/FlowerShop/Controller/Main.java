package FlowerShop.Controller;



public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            try{
                System.out.println(i + " is simple: " + MaksLoh.recursion(i, 2));// второй параметр всегда должен быть два!
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
