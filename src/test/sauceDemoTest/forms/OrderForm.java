package sauceDemoTest.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import sauceDemoTest.pages.BasePage;

/**
 * Форма заказа
 *
 * @author amoiseev
 * @since 09.03.2025
 */
public class OrderForm extends BasePage
{
    public OrderForm(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    public void enterName(String name)
    {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterCardNumber(String cardNumber)
    {
        driver.findElement(By.id("card")).sendKeys(cardNumber);
    }

    public void clickPurchase()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
    }

    public void testSuccessfulOrderFormAppear()
    {
        WebElement alertText = driver.findElement(By.xpath("//*[contains(text(), 'Thank you for your purchase!')]"));

        assertTrue("Сообщение об успешном заказе не отображается", alertText.isDisplayed());
    }
}