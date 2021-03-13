package by.darashuk;

import by.darashuk.api.services.ITextHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.darashuk.entity.Text;
import by.darashuk.services.TextHandler;

public class TestSortByAlphabet {

    private Text testedText;
    private String expectedSortByAlphabetString;

    private final ITextHandler textHandler = new TextHandler();

    @BeforeClass
    public void beforeClass() {

        testedText = new Text("src/test/resources/ForTest.txt");
        InitDataForTests initData = new InitDataForTests();

        expectedSortByAlphabetString = initData.getStringSortingByAlphabetString();

    }

    @Test
    public void testSortByAlphabet() {

        String actualSortByAlphabetString = textHandler.sortByAlphabet(testedText);
        System.out.println(actualSortByAlphabetString + "\n");

        Assert.assertEquals(actualSortByAlphabetString, expectedSortByAlphabetString);
        System.out.println(expectedSortByAlphabetString);
    }

}
