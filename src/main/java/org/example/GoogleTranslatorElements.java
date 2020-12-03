package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public interface GoogleTranslatorElements {

    public SelenideElement getSourceInput();

    public SelenideElement getSelectLanguageButton();

    public ElementsCollection getLanguageButtonCollection();

    public SelenideElement getSpeakButton();

}
