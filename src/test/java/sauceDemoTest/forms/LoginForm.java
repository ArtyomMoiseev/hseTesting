package sauceDemoTest.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import sauceDemoTest.pages.BasePage;

/**
 * Форма авторизации
 *
 * @author amoiseev
 * @since 09.03.2025
 */
public class LoginForm extends BasePage
{
    public LoginForm(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    public void enterLogin(String username)
    {
        driver.findElement(By.id("loginusername")).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    public void clickLogin()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }
}