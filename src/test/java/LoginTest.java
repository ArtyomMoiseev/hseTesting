import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Тестирование страницы авторизации сервиса <a href="https://www.saucedemo.com/">saucedemo.com</a>
 *
 * @author amoiseev
 * @since 25.02.2025
 */
public class LoginTest {

    /*
    1.Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standard_user
    3. Оставить поле password пустым (ввести пробел)
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Password is required
     */
    @Test
    public void checkNegativeLoginWithEmptyPassword() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");

        driver.quit();
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standard_user
    3. Ввести в поле password значение secret_sauce (корректный пароль)
    4. Нажать кнопку Login
    5. Проверить, что на странице отображается элемент title
     */
    @Test
    public void checkPositiveLogin() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        Boolean titleIsVisible = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();

        Assert.assertTrue(titleIsVisible);

        driver.quit();
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standard_user
    3. Ввести в поле password значение incorrect_password (некорректный пароль)
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Username and password do not match any user in this service
     */
    @Test
    public void checkIncorrectPassword() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("incorrect_password");
        driver.findElement(By.id("login-button")).click();


        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение locked_out_user (заблокированный пользователь)
    3. Ввести в поле password значение secret_sauce (корректный пароль)
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Sorry, this user has been locked out.
     */
    @Test
    public void checkLoginUnderLockedOutUser() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");

        driver.quit();
    }
}