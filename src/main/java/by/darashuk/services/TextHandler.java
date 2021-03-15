
package by.darashuk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.darashuk.api.services.ITextHandler;
import org.apache.log4j.Logger;
import by.darashuk.api.composite.ICompositeText;
import by.darashuk.entity.Text;
import by.darashuk.entity.Word;

public class TextHandler implements ITextHandler {

	private final static Logger logger = Logger.getLogger(TextHandler.class);
	private final String WORD_STARTING_WITH_CONSONANT = "^(?i:[qwrtplkjhgfdszxcvbnm]).*";

	public ArrayList<ICompositeText> getAllParagraphs(Text text) {
		logger.info("IN getAllParagraphs() :  getting all paragraphs... ");
		ArrayList<ICompositeText> textList = new ArrayList<>();

		if (text == null) {
			logger.info("IN getAllSentences() : We got a problem : text == null !");
		} else {
			textList = text.getListOfElements();
		}
		return textList;
	}

	public ArrayList<ICompositeText> getAllSentences(Text text) {
		logger.info("IN getAllSentences() :  getting all sentences... ");
		ArrayList<ICompositeText> allSentences = new ArrayList<>();

		if (text == null) {
			logger.info("IN getAllSentences() : We got a problem : text == null !");
		} else {
			getAllParagraphs(text).forEach(par -> allSentences.addAll(par.getListOfElements()));
		}
		return allSentences;
	}

	public ArrayList<ICompositeText> getAllWordsAndPunctuation(Text text) {
		logger.info("IN getAllWordsAndPunctuation() :  getting all words and punctuation... ");
		ArrayList<ICompositeText> allWordsAndPunctuation = new ArrayList<>();

		if (text == null) {
			logger.info("IN getAllWordsAndPunctuation() : We got a problem : text == null !");
		} else {
			getAllSentences(text).forEach(sen -> allWordsAndPunctuation.addAll(sen.getListOfElements()));
		}
		return allWordsAndPunctuation;
	}

	public ArrayList<ICompositeText> getAllWords(Text text) {
		logger.info("IN getAllWords() :  getting all words... ");
		ArrayList<ICompositeText> textList = new ArrayList<>();

		if (text == null) {
			logger.info("IN getAllWords() : We got a problem : text == null !");
		} else {
			textList = getAllWordsAndPunctuation(text).stream().filter(el -> el instanceof Word)
					.collect(Collectors.toCollection(ArrayList::new));
		}
		return textList;
	}

	@Override
	public String sortByAlphabet(Text text) {
		logger.info("IN sortByAlphabet() :  sorting was started");
		StringBuilder resultString = new StringBuilder();
		char newLetter = '0';

		if (text == null) {
			logger.info("IN sortByAlphabet() : We got a problem : text == null !");
		} else {
			ArrayList<String> arrayOfWords = getAllWords(text).stream().map(el -> el.returnAsString().toLowerCase())
					.distinct().sorted().collect(Collectors.toCollection(ArrayList::new));

			/**
			 *The sorted list should be displayed according to the condition:
			 *  each new bull is capitalized and on a new line
			 */

			for (String word : arrayOfWords) {
				if (word.charAt(0) == newLetter) {
					resultString.append(", ").append(word);
				} else {
					newLetter = word.charAt(0);
					char[] s = word.toCharArray();
					s[0] = Character.toUpperCase(s[0]);
					resultString.append("\n").append(String.valueOf(s));
				}
			}
		}
		return String.valueOf(resultString);
	}

	@Override
	public String removeSomeWords(Text text) {
		logger.info("IN removeSomeWords() : removing by given length was started...");
		StringBuilder resultString = new StringBuilder();

		if (text == null) {
			logger.info("IN removeSomeWords() : We got a problem : text == null !");
		} else {
			final int WORD_LENGTH = 3;
			ArrayList<String> arrayOfWords = getAllWords(text).stream().map(el -> el.returnAsString().toLowerCase())
					.distinct().collect(Collectors.toCollection(ArrayList::new));

			arrayOfWords.removeIf(element ->
					(element.length() == WORD_LENGTH)
							&& (element.matches(WORD_STARTING_WITH_CONSONANT)));

			for (String word : arrayOfWords) {
				resultString.append(word).append(", ");
			}
		}
		return resultString.toString();
	}
}


