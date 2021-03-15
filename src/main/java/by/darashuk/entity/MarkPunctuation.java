package by.darashuk.entity;

import by.darashuk.api.composite.ICompositeText;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;


@Data
public class MarkPunctuation implements ICompositeText {

    private String charPunctuation;

    @Override
    public String returnAsString() {
        return charPunctuation;
    }

    public MarkPunctuation(String charPunctuation) {
        this.charPunctuation = charPunctuation;
    }
}
