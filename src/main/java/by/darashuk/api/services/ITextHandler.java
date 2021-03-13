package by.darashuk.api.services;

import by.darashuk.entity.Text;

public interface ITextHandler {

    String removeSomeWords(Text text);

    String sortByAlphabet(Text text);

}
