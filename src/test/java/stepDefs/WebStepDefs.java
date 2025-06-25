package stepDefs;

import Pages.*;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WebStepDefs extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;
    ComputersPage computersPage;
    DesktopPage desktopPage;
    BuildYourOwnComputerPage buildPage;


    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        setup();
        driver.get("https://demowebshop.tricentis.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("User logs in with email {string} and password {string}")
    public void userLogsIn(String email, String password) {

        loginPage.login(email, password);
    }

    @Then("User navigates to the Computers category")
    public void userNavigatesToComputersCategory() {
        homePage = new HomePage(driver);
        homePage.navigateToComputers();
    }

    @Then("User selects the Desktops category")
    public void userSelectsDesktopsCategory() {
        computersPage = new ComputersPage(driver);
        computersPage.selectDesktopsCategory();
    }

    @Then("User Clicks build your own computer")
    public void userClicksBuildYourOwnComputer() {
        desktopPage = new DesktopPage(driver);
        desktopPage.selectBuildYourOwnComputer();
    }

    @Then("User customizes a Build Your Own Computer and adds it to the cart")
    public void userCustomizesAndAddsProduct() {
        buildPage = new BuildYourOwnComputerPage(driver);

        buildPage.selectProcessorByValue("14");
        buildPage.selectRAMByValue("16");
        buildPage.chooseHDD("400");
        buildPage.chooseOS("windows 10");
        buildPage.selectSoftware(true, true, false);
        buildPage.setQuantity(1);
        buildPage.clickAddToCart();
        Assert.assertEquals(buildPage.getSuccessMessageText(), "The product has been added to your shopping cart");

    }
    @Then("When User Navigated To Shopping Cart ")
    public void whenUserNavigateToShoppingCar(){

    }








}



