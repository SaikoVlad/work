package by.bntu.fitr.povt.cng.model.logic.JSFLogic.SearchCriterias;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public class SearchWherePriceLower implements Searcher<Toy, Double> {
    @Override
    public boolean searchTo(Toy object, Double param) {
        return object.getPrice() <= param;
    }
}
