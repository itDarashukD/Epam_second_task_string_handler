package by.darashuk.entity;

import by.darashuk.api.composite.ICompositeText;
import lombok.Data;

import java.util.ArrayList;


@Data
public class Paragraph implements ICompositeText {

	private ArrayList<ICompositeText> listOfSentences = new ArrayList<>();

	@Override
	public void addElementToList(ICompositeText sentence) {
		listOfSentences.add(sentence);
	}

	@Override
	public String returnAsString() {

		StringBuilder paragraph = new StringBuilder();

		for (ICompositeText elements : listOfSentences) {
			paragraph.append(elements.returnAsString());
		}
		return String.valueOf(paragraph);
	}

	@Override
	public ArrayList<ICompositeText> getListOfElements() {
		return listOfSentences;
	}

	@Override
	public void removeElementFromList(ICompositeText sentence) {
		listOfSentences.remove(sentence);
	}

}
