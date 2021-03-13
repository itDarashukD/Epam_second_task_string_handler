package by.darashuk.api.services;

import by.darashuk.api.composite.ICompositeText;

import java.util.ArrayList;

public interface ITextParser {

    public ArrayList<ICompositeText> textParsing(String parseString);

}
