package by.bntu.fitr.povt.cng.controller;
import by.bntu.fitr.povt.cng.model.Creator;
import by.bntu.fitr.povt.cng.model.collections.deprecated.QueueMasImpl;
import by.bntu.fitr.povt.cng.model.entity.Garland;
import by.bntu.fitr.povt.cng.model.entity.Lights;
import by.bntu.fitr.povt.cng.model.entity.StuffedToys;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import by.bntu.fitr.povt.cng.model.entity.container.JSFContainer.JSFArrayTree;
import by.bntu.fitr.povt.cng.model.entity.container.SmartTree;
import by.bntu.fitr.povt.cng.model.entity.container.ToyType;
import by.bntu.fitr.povt.cng.model.entity.container.Tree;
import by.bntu.fitr.povt.cng.model.logic.JSFLogic.ComparableSort;
import by.bntu.fitr.povt.cng.model.logic.JSFLogic.Search;
import by.bntu.fitr.povt.cng.model.logic.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

//        Garland garland = new Garland(1,1,1,1,1,"123123");
//        StuffedToys stuffedToys = new StuffedToys(2,3,3,"3","man",3);
//        Lights lights = new Lights(6,2,2,2,2,2);
//        List<Toy> toys = new ArrayList<>();
//        toys.addAll(Arrays.asList(lights,garland,stuffedToys));
//        Search.search(toys,Search.SearchType.PRICE_TO_GREATER, 1.1);
        var one = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 14, 19));
        var two = new ArrayList<>(Arrays.asList(2, 4, 10, 11, 12, 16, 18, 21, 22));
        System.out.println("First list: " + one + "\nSecond list: " + two);
        NewList.split(one,two);
        System.out.println("Final: " + one);
    }

}

class NewList{

    static void split(ArrayList<Integer> one, ArrayList<Integer> two){
        var size = one.size() > two.size() ? one.size() : two.size();
        var i = 0;
        var j = 0;
        while (j < size){
            if (i < one.size() - 1 && one.get(i).compareTo(two.get(j)) < 0){
                i++;
            }else{
                if (one.get(i).compareTo(two.get(j)) < 0){
                    one.add(two.get(j));
                }else{
                    one.add(i,two.get(j));
                }
                j++;
            }
        }

    }


}