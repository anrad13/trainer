package org.example;;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleTranslatorForm {

    private final static String PAGE_URL = "https://translate.google.ru/";
    private final static String LANGUAGE = "немецкий";
    private SelenideElement sourceInput = $(byId("source"));

    public GoogleTranslatorForm() {
        init();
    }

    public void init() {
        Selenide.open(PAGE_URL);
        selectLanguage();
    }

    public void say(String text) {
        sourceInput.clear();
        sourceInput.setValue(text);
        sleep1();
        Selenide.actions().sendKeys(Keys.ESCAPE).build().perform();
        sleep1();
        $$(By.xpath("//div[contains(@class,'src-tts left-positioned ttsbutton jfk-button-flat source-or-target-footer-button jfk-button')]"))
                .first().click();
    }

    private void selectLanguage() {
        $(By.xpath("//div[contains(@class,'sl-more tlid-open-source-language-list')]")).click();
        $$(By.xpath("//div[contains(@class,'language_list_item language_list_item_language_name')]"))
                .findBy(text(LANGUAGE)).click();
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
