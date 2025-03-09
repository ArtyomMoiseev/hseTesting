package sauceDemoTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница продукта
 *
 * @author amoiseev
 * @since 09.03.2025
 */
public class ProductPage extends BasePage
{
    public ProductPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    public void clickAddToCart()
    {
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#tbodyid > div.row > div > a")));
        addToCartButton.click();
    }
}