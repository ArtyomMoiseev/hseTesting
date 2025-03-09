package sauceDemoTest.tests;

import org.junit.Before;
import org.junit.Test;

import sauceDemoTest.TestUtils.RandomStringGenerator;
import sauceDemoTest.forms.LoginForm;
import sauceDemoTest.forms.OrderForm;
import sauceDemoTest.forms.SignupForm;
import sauceDemoTest.pages.CartPage;
import sauceDemoTest.pages.ProductPage;
import sauceDemoTest.pages.ProductStorePage;

/**
 * Тесты магазина <a href="https://www.demoblaze.com/index.html">demoblaze.com</a>
 *
 * @author amoiseev
 * @since 07.03.2025
 */
public class StoreTest extends BaseTest
{
    private ProductStorePage productStorePage;
    private SignupForm signupForm;
    private LoginForm loginForm;
    private ProductPage productPage;
    private CartPage cartPage;
    private OrderForm orderForm;

    @Before
    public void beforeTests()
    {
        signupForm = new SignupForm(driver, wait);
        productStorePage = new ProductStorePage(driver, wait);
        loginForm = new LoginForm(driver, wait);
        productPage = new ProductPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        orderForm = new OrderForm(driver, wait);
    }

    /**
     * Тестовый сценарий: Регистрация, авторизация и покупка товара на сайте demoblaze.com.
     *
     * <h2>Предварительные шаги:</h2>
     * <ol>
     *   <li>Открыть страницу demoblaze.com</li>
     *   <li>Нажать кнопку "Sign Up"</li>
     *   <li>Ввести в поле username случайный логин</li>
     *   <li>Ввести в поле password случайный пароль</li>
     *   <li>Нажать кнопку "Sign Up" на форме</li>
     *   <li>Закрыть всплывающее окно</li>
     *   <li>Нажать кнопку "Login"</li>
     *   <li>Ввести в поле username случайный логин с шага 3</li>
     *   <li>Ввести в поле password случайный пароль с шага 4</li>
     *   <li>Нажать кнопку "Login" на форме</li>
     *   <li>Перейти на карточку товара "Samsung galaxy s6"</li>
     *   <li>Нажать кнопку "Add to cart"</li>
     *   <li>Нажать кнопку "Cart" на странице</li>
     *   <li>Ввести случайное имя и номер карты</li>
     *   <li>Нажать кнопку "Place order"</li>
     * </ol>
     *
     * <h2>Проверки:</h2>
     * <ul>
     *   <li>Появилась модальная, сообщающая об успешном выполнении заказа.</li>
     * </ul>
     */
    @Test
    public void buyProductTest()
    {
        productStorePage.openPage();
        productStorePage.clickSignUp();

        String testLogin = RandomStringGenerator.generateRandomString(10);
        String testPassword = RandomStringGenerator.generateRandomString(10);

        signupForm.enterLogin(testLogin);
        signupForm.enterPassword(testPassword);
        signupForm.clickSignUp();
        signupForm.acceptAlert();

        productStorePage.clickLogin();

        loginForm.enterLogin(testLogin);
        loginForm.enterPassword(testPassword);
        loginForm.clickLogin();

        productStorePage.clickOnProductByName("Samsung galaxy s6");
        productPage.clickAddToCart();
        productPage.acceptAlert();

        productStorePage.clickCart();
        cartPage.clickPlaceOrder();

        orderForm.enterName(RandomStringGenerator.generateRandomString(10));
        orderForm.enterCardNumber(RandomStringGenerator.generateStringWith16DigitRandomNumber());
        orderForm.clickPurchase();
        orderForm.testSuccessfulOrderFormAppear();
    }
}