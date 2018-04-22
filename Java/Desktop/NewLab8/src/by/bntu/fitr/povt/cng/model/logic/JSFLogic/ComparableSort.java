package by.bntu.fitr.povt.cng.model.logic.JSFLogic;

import by.bntu.fitr.povt.cng.model.collections.comparators.*;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

import java.util.*;

public class ComparableSort {


    public enum SortType{
        PRICE_TO_GREATER, WEIGHT_TO_GREATER, SIZE_TO_GREATER, PRICE_TO_LOWER, WEIGHT_TO_LOWER, SIZE_TO_LOWER
    }

    private static HashMap<SortType,Comparator<Toy>> map = new HashMap<>();

    static {
        map.put(SortType.PRICE_TO_GREATER,new PriceComparatorToGreater());
        map.put(SortType.WEIGHT_TO_GREATER, new WeightComparatorToGreater());
        map.put(SortType.SIZE_TO_GREATER, new SizeComparatorToGreater());
        map.put(SortType.PRICE_TO_LOWER, new PriceComparatorToLower());
        map.put(SortType.WEIGHT_TO_LOWER, new WeightComparatorToLower());
        map.put(SortType.SIZE_TO_LOWER, new SizeComparatorToLower());
    }

    public static void sort(List<Toy> list, SortType sortType) throws Exception {
        if (list.isEmpty()){
            throw new Exception("List is empty");
        }
        Collections.sort(list,map.get(sortType));
    }

    public static void addComparator(SortType type, Comparator<Toy> comparator){
        map.put(type, comparator);
    }

}
