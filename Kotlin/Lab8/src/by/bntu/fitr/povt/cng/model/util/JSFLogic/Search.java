package by.bntu.fitr.povt.cng.model.util.JSFLogic;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import by.bntu.fitr.povt.cng.model.util.JSFLogic.SearchCriterias.SearchWherePriceBigger;
import by.bntu.fitr.povt.cng.model.util.JSFLogic.SearchCriterias.Searcher;

import java.util.*;

public class Search {



    public enum SearchType {
        PRICE_TO_GREATER, WEIGHT_TO_GREATER, SIZE_TO_GREATER, PRICE_TO_LOWER, WEIGHT_TO_LOWER, SIZE_TO_LOWER
    }

    private static Map<SearchType,Searcher> map;


    static {
        map = new HashMap<>();
        map.put(SearchType.PRICE_TO_GREATER, new SearchWherePriceBigger());
    }

    public static void search(List<Toy> list, SearchType searchCritery, double param) throws Exception {
        if (list.isEmpty()){
            throw new Exception("List is empty");
        }
        List newList = new ArrayList();
        for (Toy toy : list) {
            if (map.get(searchCritery).searchTo(toy,param)){
                newList.add(toy);
            }
        }
//        System.out.println(newList);
    }

//    public static void addComparator(ComparableSort.SortType type, Comparator<Toy> comparator){
//        map.put(type, comparator);
//    }


}
