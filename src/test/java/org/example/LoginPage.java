package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwdField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[text()='Введите корректный e-mail']")
    public WebElement invalidEmailError;


    public void clickSignInButton() {
        signInButton.click(); }

    public void fillEmailField(String login) {
        emailField.sendKeys(login); }

    public void fillPasswordField(String login) {
        passwdField.sendKeys(login); }

    public void clickLoginBtn() {
        loginBtn.click(); }

}