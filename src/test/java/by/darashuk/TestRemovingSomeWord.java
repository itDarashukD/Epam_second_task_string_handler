package by.darashuk;

import by.darashuk.api.services.ITextHandler;
import by.darashuk.entity.Text;
import by.darashuk.services.TextHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRemovingSomeWord {

    private Text testedText;
    private String expectedRemovingSomeWord;
    private final ITextHandler textHandler = new TextHandler();

    @BeforeClass
    public void beforeClass() {
        InitDataForTests initData = new InitDataForTests();
        expectedRemovingSomeWord = initData.getRemovingSomeWord();
        testedText = new Text("src/test/resources/ForTest.txt");
    }

    @Test
    public void testSortByAlphabet() {
        String actualSortByAlphabetString = textHandler.removeSomeWords(testedText);
        System.out.println(actualSortByAlphabetString);

        Assert.assertEquals(actualSortByAlphabetString, expectedRemovingSomeWord);
        System.out.println(expectedRemovingSomeWord);
    }
}
