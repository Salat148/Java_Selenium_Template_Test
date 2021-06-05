package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void loginTest() {
        loginPage.clickSignInButton();
        loginPage.fillEmailField("test");
        loginPage.fillPasswordField("test");
        loginPage.clickLoginBtn();
        Boolean isPresent = driver.findElements(By.xpath("//*[text()='Введите корректный e-mail']")).size() > 0;
        Assert.assertTrue(isPresent);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit(); } }