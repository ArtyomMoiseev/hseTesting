package sauceDemoTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница корзины
 *
 * @author amoiseev
 * @since 09.03.2025
 */
public class CartPage extends BasePage
{
    public CartPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    public void clickPlaceOrder()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }
}