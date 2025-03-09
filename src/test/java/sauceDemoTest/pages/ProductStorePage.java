package sauceDemoTest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница товаров магазина <a href="https://www.demoblaze.com/index.html">demoblaze.com</a>
 *
 * @author amoiseev
 * @since 02.03.2025
 */
public class ProductStorePage extends BasePage
{
    @FindBy(id = "cartur")
    private WebElement cartLink;
    @FindBy(id = "login2")
    private WebElement loginLink;
    @FindBy(id = "signin2")
    private WebElement signUpLink;

    public ProductStorePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void clickOnProductByName(String productName)
    {
        // Для экономии времени пришлось сделать костыль. Можно лучше, но времени нет(
        String xpathExpression = "//div[@id='tbodyid']//*[contains(text(),'" + productName + "')]";

        int attempts = 0;
        boolean clicked = false;
        while (attempts < 2 && !clicked)
        {
            try
            {
                WebElement productElement = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression))
                );
                productElement.click();
                clicked = true;
            }
            catch (StaleElementReferenceException e)
            {
                attempts++;
            }
        }
        if (!clicked)
        {
            throw new RuntimeException("Не удалось кликнуть по продукту: " + productName);
        }
    }

    public void openPage()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/index.html");
    }

    public void clickCart()
    {
        cartLink.click();
    }

    public void clickLogin()
    {
        loginLink.click();
    }

    public void clickSignUp()
    {
        signUpLink.click();
    }
}