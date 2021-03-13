package by.darashuk.entity;

import by.darashuk.api.composite.ICompositeText;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;


@Data
@AllArgsConstructor
public class Word implements ICompositeText {

    private String word;

    @Override
    public String returnAsString() {
        return word;
    }

    @Override
    public ArrayList<ICompositeText> getListOfElements() {

        return null;
    }

    @Override
    public void addElementToList(ICompositeText word) {

    }

    @Override
    public void removeElementFromList(ICompositeText element) {

    }
}
