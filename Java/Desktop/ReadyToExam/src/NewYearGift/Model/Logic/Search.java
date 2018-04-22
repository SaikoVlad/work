package NewYearGift.Model.Logic;

import NewYearGift.Model.Entity.Container.Gift;

public class Search {


    public static String findByCreator(Gift gift, String creator){
        for (int i = 0; i < gift.getSize(); i++) {
            if (gift.getCandy(i).getCreator().equals(creator)){
                return "That's our toy with creator " + creator + ":\n" + gift.getCandy(i).toString();
            }
        }
        return "No one";
    }

    public static String findByWeight(Gift gift, double weight){
        for (int i = 0; i < gift.getSize(); i++) {
            if (gift.getCandy(i).getWeight() == weight){
                return "That's our toy with weight " + weight + ":\n" + gift.getCandy(i).toString();
            }
        }
        return "No one";
    }

    public static String findByPrice(Gift gift, double price){
        for (int i = 0; i < gift.getSize(); i++) {
            if (gift.getCandy(i).getPrice() == price){
                return "That's your toy with price " + price + ":\n" + gift.getCandy(i).toString();
            }
        }
        return "No one";
    }

}
