package by.darashuk.services;

import java.util.ArrayList;
import java.util.regex.Pattern;

import by.darashuk.api.services.ITextParser;
import com.beust.jcommander.Strings;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import by.darashuk.api.composite.ICompositeText;
import by.darashuk.entity.Paragraph;
import by.darashuk.entity.MarkPunctuation;
import by.darashuk.entity.Sentence;
import by.darashuk.entity.Word;

public class TextParser implements ITextParser {

	private final static Logger logger = Logger.getLogger(TextParser.class);
	private static final String PUNCTUATION_ELEMENTS = "[-,:;()]";
	private static final String SENTENCES = "[.?!]";
	private static final String WORDS_ELEMENTS = "\\p{Alnum}";

	@Override
	public ArrayList<ICompositeText> textParsing(String parseString) {
		ArrayList<ICompositeText> listOfParagraphs = new ArrayList<>();

		if (StringUtils.isEmpty(parseString) ){
			logger.info("IN textParsing() : We got a problem : String parseString == isEmpty !");
		} else {
			logger.info("IN textParsing() : parsing text was started");

			StringBuilder builderWords = new StringBuilder();
			char[] charFromParseString = parseString.toCharArray();
			ICompositeText newSentence = new Sentence();
			ICompositeText newParagraph = new Paragraph();

			for (char symbol : charFromParseString) {

				if (Pattern.matches(WORDS_ELEMENTS, String.valueOf(symbol))) {
					builderWords.append(symbol);
				}
				if (Pattern.matches(SENTENCES, String.valueOf(symbol))) {
					if (builderWords.length() != 0) {
						newSentence.addElementToList(new Word(builderWords.toString()));
						builderWords.setLength(0);
					}
					newSentence.addElementToList(new MarkPunctuation(String.valueOf(symbol)));
					newParagraph.addElementToList(newSentence);
					newSentence = new Sentence();
				}
				if (Pattern.matches(PUNCTUATION_ELEMENTS, String.valueOf(symbol))) {
					newSentence.addElementToList(new Word(builderWords.toString()));
					newSentence.addElementToList(new MarkPunctuation(String.valueOf(symbol)));
					builderWords.setLength(0);
				}
				if (symbol == ' ' && builderWords.length() != 0) {
					newSentence.addElementToList(new Word(builderWords.toString()));
					builderWords.setLength(0);
				}
				if (String.valueOf(symbol).equals("\n")) {
					listOfParagraphs.add(newParagraph);
					newParagraph = new Paragraph();
				}
			}
			listOfParagraphs.add(newParagraph);
		}
		return listOfParagraphs;
	}
}
