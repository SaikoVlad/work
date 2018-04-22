package by.bntu.fitr.povt.cng.model.logic;

import by.bntu.fitr.povt.cng.model.entity.container.Tree;

public class Search {
    //mas

    public static String findBySize(Tree tree, double size){
        for (int i = 0; i < tree.getSize(); i++) {
            if (tree.getToy(i).getSize() == size){
                return "That's our toy with size " + size + ":\n" + tree.getToy(i).toString();
            }
        }
        return "No one";
    }

    public static String findByWeight(Tree tree, double weight){
        for (int i = 0; i < tree.getSize(); i++) {
            if (tree.getToy(i).getWeight() == weight){
                return "That's our toy with weight " + weight + ":\n" + tree.getToy(i).toString();
            }
        }
        return "No one";
    }

    public static String findByPrice(Tree tree, double price){
        for (int i = 0; i < tree.getSize(); i++) {
            if (tree.getToy(i).getPrice() == price){
                return "That's your toy with price " + price + ":\n" + tree.getToy(i).toString();
            }
        }
        return "No one";
    }

}
