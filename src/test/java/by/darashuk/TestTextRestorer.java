package by.darashuk;

import by.darashuk.api.services.ITextRestorer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.darashuk.services.TextRestorer;

public class TestTextRestorer {

    private String expectedTextRestoredString;
    private final ITextRestorer textRestorer = new TextRestorer();

    @BeforeMethod
    public void beforeMethod() {
	InitDataForTests initData = new InitDataForTests();
	expectedTextRestoredString = initData.getTextForParsingString();
    }

    @Test
    public void testTextRestorer() {
        String actualTextRestoredString = textRestorer.textRestoring();
        System.out.println(actualTextRestoredString + "\n");

        Assert.assertEquals(actualTextRestoredString, expectedTextRestoredString);
        System.out.println(expectedTextRestoredString);
    }
}
