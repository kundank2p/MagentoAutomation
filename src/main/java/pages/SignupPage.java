package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SignupPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By emailField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("password-confirmation");
    private final By createAccountButton = By.xpath("//button[@title='Create an Account']");
    private final By accountMenu = By.xpath("//button[@data-action='customer-menu-toggle']");
    private final By logoutLink = By.linkText("Sign Out");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void completeRegistration(String firstName, String lastName, String email, String password) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(emailField, email);
        enterText(passwordField, password);
        enterText(confirmPasswordField, password);
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(accountMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public boolean isSignupSuccessful() {
        try {
            wait.until(ExpectedConditions.or(ExpectedConditions.urlContains("customer/account") // If redirected to login page
            ));
            return Objects.requireNonNull(driver.getCurrentUrl()).contains("customer/account");
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
}




