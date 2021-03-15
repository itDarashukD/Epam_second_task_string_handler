package by.darashuk.entity;

import java.util.ArrayList;

import by.darashuk.api.composite.ICompositeText;
import by.darashuk.fileRead.TextReader;
import by.darashuk.api.services.ITextParser;
import by.darashuk.services.TextParser;
import lombok.Data;

@Data
public class Text implements ICompositeText {

    private String tempText;
    private ArrayList<ICompositeText> listOfParagraphs;
    private ITextParser textParser = new TextParser();

    public Text(String fileName) {
        tempText = TextReader.getInstance().readFromFile(fileName);
        this.listOfParagraphs = textParser.textParsing(tempText);
    }

    @Override
    public void addElementToList(ICompositeText paragraph) {
        listOfParagraphs.add(paragraph);
    }

    @Override
    public ArrayList<ICompositeText> getListOfElements() {
        return listOfParagraphs;
    }

    @Override
    public String returnAsString() {
        StringBuilder text = new StringBuilder();
        for (ICompositeText elements : listOfParagraphs) {
            text.append(elements.returnAsString());
        }
        return text.toString();
    }

    @Override
    public void removeElementFromList(ICompositeText paragraph) {
        listOfParagraphs.remove(paragraph);
    }
}
