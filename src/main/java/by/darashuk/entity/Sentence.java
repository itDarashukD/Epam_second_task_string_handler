package by.darashuk.entity;

import by.darashuk.api.composite.ICompositeText;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Sentence implements ICompositeText {

	private ArrayList<ICompositeText> listPartsOfSentence = new ArrayList<>();

	@Override
	public ArrayList<ICompositeText> getListOfElements() {
		return listPartsOfSentence;
	}

	@Override
	public void addElementToList(ICompositeText word) {
		listPartsOfSentence.add(word);
	}

	@Override
	public void removeElementFromList(ICompositeText word) {
		listPartsOfSentence.remove(word);
	}

	@Override
	public String returnAsString() {
		StringBuilder sentence = new StringBuilder();
		for (ICompositeText element : listPartsOfSentence) {
			sentence.append(element.returnAsString());
		}
		return sentence.toString();
	}
}
