package by.darashuk.services;

import java.util.ArrayList;

import by.darashuk.api.services.ITextRestorer;
import by.darashuk.entity.*;
import org.apache.log4j.Logger;

import by.darashuk.api.composite.ICompositeText;

public class TextRestorer implements ITextRestorer {

	private final static Logger logger = Logger.getLogger(TextRestorer.class);
	private final String TESTED_TEXT = "src/test/resources/ForTest.txt";

	@Override
	public String textRestoring() {

		logger.info("IN textRestoring() : restoring text was started");

		StringBuilder textRestore = new StringBuilder();
		ICompositeText compositeText = new Text(TESTED_TEXT);

		ArrayList<ICompositeText> listParagraphs = compositeText.getListOfElements();

		// for all Paragraphs
		for (int par = 0; par < listParagraphs.size(); par++) {
			textRestore.append("\t");
			// for each sentences from paragraph[s]
			for (int sent = 0; sent < listParagraphs.get(par).getListOfElements().size(); sent++) {

				if (sent != 0 && sent < listParagraphs.get(par).getListOfElements().size()) {
					textRestore.append(' ');
				}
				// for each words or marks punctuation
				for (int i = 0; i < listParagraphs.get(par).getListOfElements().get(sent).getListOfElements()
						.size(); i++) {

					if (listParagraphs.get(par).getListOfElements().get(sent).getListOfElements()
							.get(i) instanceof Word) {

						if (i != 0 && i != listParagraphs.get(par).getListOfElements().get(sent).getListOfElements()
								.size()) {
							textRestore.append(' ');
						}
						textRestore.append(listParagraphs.get(par).getListOfElements().get(sent).getListOfElements()
								.get(i).returnAsString());
					}

					if (listParagraphs.get(par).getListOfElements().get(sent).getListOfElements()
							.get(i) instanceof MarkPunctuation) {

						textRestore.append(listParagraphs.get(par).getListOfElements().get(sent).getListOfElements()
								.get(i).returnAsString());
					}
				}
			}
			if (par < listParagraphs.size() - 1) {
				textRestore.append("\n");
			}

		}
		return textRestore.toString();
	}

}

