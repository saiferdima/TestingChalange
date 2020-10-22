package automationSolution.pageObjects;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage {
    public void login(String login, String password) {
        $(By.id("user-name")).setValue(login);
        $(By.id("password")).setValue(password).pressEnter();
    }
}