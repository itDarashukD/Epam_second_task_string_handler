package by.darashuk.entity;

import by.darashuk.api.composite.ICompositeText;
import lombok.Data;

@Data
public class Word implements ICompositeText {

    private String word;

    @Override
    public String returnAsString() {
        return word;
    }

    public Word(String word) {
        this.word = word;
    }
}
