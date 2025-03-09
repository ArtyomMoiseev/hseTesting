package sauceDemoTest;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

/**
 * Базовый тест сайта <a href="https://www.demoblaze.com/index.html">demoblaze.com</a>
 *
 * @author amoiseev
 * @since 09.03.2025
 */
public class BaseTest
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void prepareFixture()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterTest()
    {
        driver.quit();
    }
}