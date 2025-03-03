//package stepDefinitions;
//
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//import pages.LoginPage;
//import utils.DriverManager;
//
//public class LoginSteps {
//    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());
//
//    @Given("I am on the login page")
//    public void navigateToLoginPage() {
//        DriverManager.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/");
//    }
//
//    @Given("I have a registered user")
//    public void createRegisteredUser() {
//        // Leverage SignupSteps to register a user
//        SignupSteps signupSteps = new SignupSteps();
//        signupSteps.navigateToSignupPage();
//        signupSteps.enterValidDetails();
//        signupSteps.submitRegistrationForm();
//        signupSteps.verifyAccountPage();
//        signupSteps.logout();
//    }
//
//    @When("I login with valid credentials")
//    public void loginWithValidCredentials() {
//        loginPage.login(SignupSteps.getGeneratedEmail(), "P@ssw0rd123!");
//    }
//
//    @When("I login with email {string} and password {string}")
//    public void loginWithEmailAndPassword(String email, String password) {
//        loginPage.login(email, password);
//    }
//
//    @Then("I should be logged in successfully")
//    public void verifyLoginSuccess() {
//        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful!");
//    }
//
//    @Then("I should see an error message {string}")
//    public void verifyErrorMessage(String expectedError) {
//        String actualError = loginPage.getErrorMessage();
//        Assert.assertEquals(actualError, expectedError, "Displayed error message does not match the expected one!");
//    }
//
//    @Given("I am logged in")
//    public void performLogin() {
//        navigateToLoginPage();
//        loginWithValidCredentials();
//        verifyLoginSuccess();
//    }
//
//    @When("I close and reopen the browser")
//    public void simulateBrowserRestart() {
//        DriverManager.resetDriver();
//        DriverManager.getDriver().get("https://magento.softwaretestingboard.com");
//    }
//
//    @And("I navigate to the account page")
//    public void navigateToAccountPage() {
//        DriverManager.getDriver().get("https://magento.softwaretestingboard.com/customer/account/");
//    }
//
//    @Then("I should still be logged in")
//    public void verifySessionPersistence() {
//        Assert.assertTrue(loginPage.isUserLoggedIn(), "Session persistence failed; user is not logged in!");
//    }
//}