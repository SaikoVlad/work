package by.bntu.fitr.povt.cng.model.util.JSFLogic.SearchCriterias;

public interface Searcher<T,P> {

    boolean searchTo(T object, P param);

}
