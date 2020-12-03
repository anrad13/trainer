package org.example;;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;

public class GoogleTranslatorForm {

    private final static String PAGE_URL = "https://translate.google.ru/";
    private final static String LANGUAGE = "немецкий";

    private SelenideElement sourceInput;
    private SelenideElement selectLanguageButton;
    private ElementsCollection languageButtonsCollection;
    private SelenideElement speakButton;

    private final GoogleTranslatorElements elements;

    public GoogleTranslatorForm() {
        Selenide.open(PAGE_URL);
        elements = getElements();
        sourceInput = elements.getSourceInput();
        selectLanguageButton = elements.getSelectLanguageButton();
        languageButtonsCollection = elements.getLanguageButtonCollection();
        speakButton = elements.getSpeakButton();
        sleep1();
        selectLanguage();
    }

    private GoogleTranslatorElements getElements() {
        return new GoogleTranslatorElementsV2();
    }

     public void say(String text) {
        sourceInput.clear();
            //System.out.println("SOURCE_INPUT_CLEAR");
        sourceInput.setValue(text);
            //System.out.println("SOURCE_INPUT_SET");
        sleep1();
        Selenide.actions().sendKeys(Keys.ESCAPE).build().perform();
        sleep1();

        speakButton.click();
            //System.out.println("SAY_ACTION_BUTTON");

    }

    private void selectLanguage() {
        selectLanguageButton.click();
        languageButtonsCollection.findBy(text(LANGUAGE)).click();
    }

    public void sleep(long sec) {
        try{
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {}
    }

    public void sleep1() {
        sleep(1);
    }

    public void sleep2() {
        sleep(2);
    }

    public void sleep5() {
        sleep(5);
    }

}
