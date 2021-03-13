package by.darashuk;

/**
 * The Class to initializing all data for tests.
 *
 * @see TestRemovingSomeWord
 * @see TestTextRestorer
 * @see TestSortByAlphabet
 */
public class InitDataForTests {

	public String getStringSortingByAlphabetString() {

		return "\nAn, and, are, as\n" + "Can, compatible\n" + "Data, different\n" + "Each, expression\n" + "Is, it\n" + "Long\n"
				+ "Mix, more\n" + "Of, or, other\n" + "Possible\n" + "Short\n" + "They, to, two, types\n"
				+ "With, within\n" + "You";
	}

	public String getTextForParsingString() {

		return "\tWithin an expression, it is possible to mix two or more different " +
				"types of data as long as they are compatible with each other.\n" +
				"\tYou can mix short and long within an expression.";
	}

	public String getRemovingSomeWord() {
		return "within, " + "an, " + "expression, " + "it, " + "is, " + "possible, "
				+ "to, " + "or, " + "more, " + "different, " + "types, "
				+ "of, " + "data, " + "as, " + "long, " + "they, " + "are, " + "compatible, " + "with, " + "each, " + "other, "
				+ "you, " + "short, " + "and, ";
	}

}
