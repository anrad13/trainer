package org.example;;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleTranslatorForm {

    private final static String PAGE_URL = "https://translate.google.ru/";
    private final static String LANGUAGE = "немецкий";

    private static final String INPUT_AREA_LOCATOR = "er8xn";
    private SelenideElement sourceInput = $(byClassName(INPUT_AREA_LOCATOR));


    private static final String SELECT_LANGUAGE_BUTTON_LOCATOR = "button.VfPpkd-Bz112c-LgbsSe.yHy1rc.eT1oJ.q7sDqe.KY3GZb.szLmtb";
    private SelenideElement selectLanguageButton = $(By.cssSelector(SELECT_LANGUAGE_BUTTON_LOCATOR));

    private static final String SELECT_LANGUAGE_DEUTSCH_BUTTON_LOCATOR = "//div[contains(@class,'PxXj2d')]";;
    private SelenideElement selectLanguageDeutschButton = $$(By.xpath(SELECT_LANGUAGE_DEUTSCH_BUTTON_LOCATOR)).findBy(text(LANGUAGE));

    private static final String SPEAK_BUTTON_LOCATOR = "button.VfPpkd-Bz112c-LgbsSe.fzRBVc.tmJved.SSgGrd.m0Qfkd";
    private SelenideElement speakButton = $(By.cssSelector(SPEAK_BUTTON_LOCATOR));

    public GoogleTranslatorForm() {
        init();
    }

    public void init() {
        Selenide.open(PAGE_URL);
        sleep1();
        selectLanguage();
    }

    public void say(String text) {
        sourceInput.clear();
            System.out.println("SOURCE_INPUT_CLEAR");
        sourceInput.setValue(text);
            System.out.println("SOURCE_INPUT_SET");
        sleep1();
        Selenide.actions().sendKeys(Keys.ESCAPE).build().perform();
        sleep1();

        //$(By.cssSelector("button.VfPpkd-Bz112c-LgbsSe.fzRBVc.tmJved.SSgGrd.m0Qfkd")).click();
        speakButton.click();
            System.out.println("SAY_ACTION_BUTTON");

    }

    private void selectLanguage() {
        $(By.cssSelector("button.VfPpkd-Bz112c-LgbsSe.yHy1rc.eT1oJ.q7sDqe.KY3GZb.szLmtb")).click();
        //selectLanguageButton.click();
            System.out.println("SELECT_LANGUAGE_BUTTON");
        $$(By.xpath("//div[contains(@class,'PxXj2d')]")).findBy(text(LANGUAGE)).click();
        //selectLanguageDeutschButton.click();
            System.out.println("SELECT_LANGUAGE_LIST_4");

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
