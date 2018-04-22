package NewYearGift.Model.Logic;

import NewYearGift.Model.Entity.Abstract.Candy;
import NewYearGift.Model.Entity.Container.Gift;

public class Sort {

    public static void insert(Gift gift) {
        Candy temp;
        int j;
        for(int i = 0; i < gift.getSize() - 1; i++){
            if (gift.getCandy(i).getPrice() > gift.getCandy(i + 1).getPrice()) {
                temp = gift.getCandy(i + 1);
                gift.changeCandy(gift.getCandy(i),i + 1);
                j = i;
                while (j > 0 && temp.getPrice() < gift.getCandy(j - 1).getPrice()) {
                    gift.changeCandy(gift.getCandy(j - 1),j);
                    j--;
                }
                gift.changeCandy(temp,j);
            }
        }
    }



    public static void bubble(Gift gift) {
        boolean sorted = true;
        for (int i = gift.getSize(); i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (gift.getCandy(j).getPrice() > gift.getCandy(j + 1).getPrice()) {
                    Candy tmp = gift.getCandy(j);
                    gift.changeCandy(gift.getCandy(j + 1), j);
                    gift.changeCandy(tmp, j + 1);
                    sorted = false;
                }
                if (sorted){
                    break;
                }

            }
        }
    }

}
