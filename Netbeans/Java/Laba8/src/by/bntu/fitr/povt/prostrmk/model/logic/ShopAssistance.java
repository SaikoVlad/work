package by.bntu.fitr.povt.prostrmk.model.logic;

import by.bntu.fitr.povt.prostrmk.model.entity.container.Basket;

public class ShopAssistance {
    public static double calculateTotalPrice(Basket basket) {
        double total = 0;
        
        for (int i = 0; i < basket.getCountO(); i++) {
            total += basket.oranges[i].getPrice();
        }
        
        for (int i = 0; i < basket.getCountB(); i++) {
            total += basket.breads[i].getPrice();
        }
        
        for (int i = 0; i < basket.getCountM(); i++) {
            total += basket.milks[i].getPrice();
        }
        
        for (int i = 0; i < basket.getCountS(); i++) {
            total += basket.s[i].getPrice();
        }
        
        
        return total;
    }
}
