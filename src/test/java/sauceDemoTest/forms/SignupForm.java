package sauceDemoTest.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import sauceDemoTest.pages.BasePage;

/**
 * Форма регистрации
 *
 * @author amoiseev
 * @since 09.03.2025
 */
public class SignupForm extends BasePage
{
    public SignupForm(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    public void enterLogin(String username)
    {
        driver.findElement(By.id("sign-username")).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        driver.findElement(By.id("sign-password")).sendKeys(password);
    }

    public void clickSignUp()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
    }
}