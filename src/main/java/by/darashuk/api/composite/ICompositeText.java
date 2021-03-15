package by.darashuk.api.composite;

import java.util.ArrayList;

public interface ICompositeText {

    String returnAsString();

    default void addElementToList(ICompositeText element) {
    }

    default void removeElementFromList(ICompositeText element) {
    }

    default ArrayList<ICompositeText> getListOfElements() {
        return null;
    }
}
