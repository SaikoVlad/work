package by.bntu.fitr.povt.cng.model;

import by.bntu.fitr.povt.cng.model.collections.deprecated.CustomCollections;
import by.bntu.fitr.povt.cng.model.collections.deprecated.QueueMasImpl;
import by.bntu.fitr.povt.cng.model.entity.Garland;
import by.bntu.fitr.povt.cng.model.entity.Lights;
import by.bntu.fitr.povt.cng.model.entity.StuffedToys;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import by.bntu.fitr.povt.cng.model.entity.container.SmartTree;
import by.bntu.fitr.povt.cng.model.entity.container.ToyType;

public class Creator {

    private static Creator creator = null;

    private Creator(ToyType... toyTypes) {

    }

    public static Creator getInstance() {
        if (creator == null) {
            creator = new Creator();
        }
        return creator;
    }

    public SmartTree getTreeObject(CustomCollections collection, ToyType... toyType) {
        if (collection == null) {
            collection = (CustomCollections) new QueueMasImpl();
        }
        SmartTree instance = new SmartTree(collection);
        for (ToyType type : toyType) {
            instance.add(creator.checkToyType(type));
        }
        return instance;
    }

    public SmartTree getTreeObjectWithStandardCollection() {
        return new SmartTree((CustomCollections) new QueueMasImpl());
    }

    private Toy checkToyType(ToyType toyType) {
        if (toyType.equals(ToyType.GARLAND)) {
            return new Garland();
        } else if (toyType.equals(ToyType.LIGHTS)) {
            return new Lights();
        } else {
            return new StuffedToys();
        }
    }

}
