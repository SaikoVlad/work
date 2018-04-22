package by.bntu.fitr.povt.cng.model.collections.comparators;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

import java.util.Comparator;

public class WeightComparatorToLower implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return (int) (o2.getWeight() - o2.getWeight());
    }
}
