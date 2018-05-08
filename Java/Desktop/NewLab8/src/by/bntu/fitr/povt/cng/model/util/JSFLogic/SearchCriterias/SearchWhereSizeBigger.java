package by.bntu.fitr.povt.cng.model.util.JSFLogic.SearchCriterias;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public class SearchWhereSizeBigger implements Searcher<Toy, Double> {
    @Override
    public boolean searchTo(Toy object, Double param) {
        return object.getSize() >= param;
    }
}
