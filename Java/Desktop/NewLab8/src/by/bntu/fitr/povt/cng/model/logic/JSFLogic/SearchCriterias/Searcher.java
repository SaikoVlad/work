package by.bntu.fitr.povt.cng.model.logic.JSFLogic.SearchCriterias;

public interface Searcher<T,P> {

    boolean searchTo(T object, P param);

}
