package by.darashuk.api.composite;

import java.util.ArrayList;

public interface ICompositeText {

    String returnAsString();

    void addElementToList(ICompositeText element);

    void removeElementFromList(ICompositeText element);

    ArrayList<ICompositeText> getListOfElements();

}
