//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class LoginPage {
//    private final WebDriver driver;
//    private final WebDriverWait wait;
//
//    // Locators
//    private final By emailField = By.id("email");
//    private final By passwordField = By.id("pass");
//    private final By loginButton = By.id("send2");
//    private final By errorMessage = By.cssSelector(".message-error");
//    private final By accountGreeting = By.cssSelector(".greet.welcome");
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    public void login(String email, String password) {
//        enterText(emailField, email);
//        enterText(passwordField, password);
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//    }
//
//    public boolean isLoginSuccessful() {
//        return wait.until(ExpectedConditions.urlContains("customer/account"));
//    }
//
//    public String getErrorMessage() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
//    }
//
//    public boolean isUserLoggedIn() {
//        try {
//            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountGreeting)).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private void enterText(By locator, String text) {
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        element.clear();
//        if (text != null) element.sendKeys(text);
//    }
//}