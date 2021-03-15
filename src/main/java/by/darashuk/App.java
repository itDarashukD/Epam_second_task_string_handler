package by.darashuk;

import by.darashuk.entity.Text;
import by.darashuk.api.services.ITextHandler;
import by.darashuk.services.TextHandler;

/**
 * 6. Print the words of the text in alphabetical order first
 * letter. Words beginning with a new letter should be printed on the red line.
 * <p>
 * 12. Remove from the text all words of a given length beginning with a consonant letter.
 */
public class App {

    public static void main(String[] args) {
        Text text = new Text("src/main/resources/MainText.txt");
        ITextHandler textHandler = new TextHandler();
        System.out.println(textHandler.sortByAlphabet(text));
        System.out.println(textHandler.removeSomeWords(text));
    }
}
