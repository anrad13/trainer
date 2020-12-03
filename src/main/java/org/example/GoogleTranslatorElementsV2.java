package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleTranslatorElementsV2 implements GoogleTranslatorElements{

    private static final String INPUT_AREA_LOCATOR = "er8xn";
    private SelenideElement sourceInput = $(byClassName(INPUT_AREA_LOCATOR));

    private static final String SELECT_LANGUAGE_BUTTON_LOCATOR = "button.VfPpkd-Bz112c-LgbsSe.yHy1rc.eT1oJ.q7sDqe.KY3GZb.szLmtb";
    private SelenideElement selectLanguageButton = $(By.cssSelector(SELECT_LANGUAGE_BUTTON_LOCATOR));

    private static final String SELECT_LANGUAGE_DEUTSCH_BUTTON_LOCATOR = "//div[contains(@class,'PxXj2d')]";;
    private ElementsCollection languageButtonCollection = $$(By.xpath(SELECT_LANGUAGE_DEUTSCH_BUTTON_LOCATOR));

    private static final String SPEAK_BUTTON_LOCATOR = "button.VfPpkd-Bz112c-LgbsSe.fzRBVc.tmJved.SSgGrd.m0Qfkd";
    private SelenideElement speakButton = $(By.cssSelector(SPEAK_BUTTON_LOCATOR));

    public SelenideElement getSourceInput() {
        return sourceInput;
    }

    public SelenideElement getSelectLanguageButton() {
        return selectLanguageButton;
    }

    public ElementsCollection getLanguageButtonCollection() {
        return languageButtonCollection;
    }

    public SelenideElement getSpeakButton() {
        return speakButton;
    }
}
