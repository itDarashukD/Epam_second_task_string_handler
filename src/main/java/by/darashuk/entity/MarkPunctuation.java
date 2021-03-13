package by.darashuk.entity;

import by.darashuk.api.composite.ICompositeText;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;


@Data
@AllArgsConstructor

public class MarkPunctuation implements ICompositeText {

    private String charPunctuation;

    @Override
    public String returnAsString() {
        return charPunctuation;
    }


    @Override
    public void removeElementFromList(ICompositeText sentence) {

    }

    @Override
    public ArrayList<ICompositeText> getListOfElements() {

        return null;
    }

    @Override
    public void addElementToList(ICompositeText element) {

    }


}
