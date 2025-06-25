package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BuildYourOwnComputerPage {
    WebDriver driver;
    WebDriverWait wait;

    public BuildYourOwnComputerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "product_attribute_16_5_4")
    WebElement processorDropdown;

    @FindBy(id = "product_attribute_16_6_5")
    WebElement ramDropdown;

    @FindBy(xpath = "//*[@id='product_attribute_16_3_6_18']")
    WebElement hdd320GB;

    @FindBy(xpath = "//input[@id='product_attribute_16_3_6_19']")
    WebElement hdd400GB;

    @FindBy(xpath = "//input[@id='product_attribute_16_4_7_44']")
    WebElement osUbuntu;

    @FindBy(xpath = "//input[@id='product_attribute_16_4_7_20']")
    WebElement osWindows7;

    @FindBy(xpath = "//input[@id='product_attribute_16_4_7_21']")
    WebElement osWindows10;

    @FindBy(xpath = "//input[@id='product_attribute_16_8_8_22']")
    WebElement softwareMSOffice;

    @FindBy(xpath = "//input[@id='product_attribute_16_8_8_23']")
    WebElement softwareAcrobat;

    @FindBy(xpath = "//input[@id='product_attribute_16_8_8_24']")
    WebElement softwareCommander;

    @FindBy(xpath = "//input[@id='addtocart_16_EnteredQuantity']")
    WebElement quantityInput;

    @FindBy(xpath = "//input[@id='add-to-cart-button-16']")
    WebElement addToCartButton;

    @FindBy(xpath = "//p[@class='content' and contains(text(), 'The product has been added to your')]")
    WebElement successMessage;


    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

   
    public void selectProcessorByValue(String value) {
        waitForVisibility(processorDropdown);
        new Select(processorDropdown).selectByValue(value);
    }

    public void selectRAMByValue(String value) {
        waitForVisibility(ramDropdown);
        new Select(ramDropdown).selectByValue(value);
    }

    public void chooseHDD(String size) {
        if (size.contains("320")) {
            waitForVisibility(hdd320GB);
            hdd320GB.click();
        } else {
            waitForVisibility(hdd400GB);
            hdd400GB.click();
        }
    }

    public void chooseOS(String os) {
        switch (os.toLowerCase()) {
            case "ubuntu":
                waitForVisibility(osUbuntu);
                osUbuntu.click();
                break;
            case "windows 7":
                waitForVisibility(osWindows7);
                osWindows7.click();
                break;
            case "windows 10":
                waitForVisibility(osWindows10);
                osWindows10.click();
                break;
        }
    }

    public void selectSoftware(boolean msOffice, boolean acrobat, boolean commander) {
        if (msOffice && !softwareMSOffice.isSelected()) {
            waitForVisibility(softwareMSOffice);
            softwareMSOffice.click();
        }
        if (acrobat && !softwareAcrobat.isSelected()) {
            waitForVisibility(softwareAcrobat);
            softwareAcrobat.click();
        }
        if (commander && !softwareCommander.isSelected()) {
            waitForVisibility(softwareCommander);
            softwareCommander.click();
        }
    }

    public void setQuantity(int qty) {
        waitForVisibility(quantityInput);
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(qty));
    }

    public void clickAddToCart() {
        waitForVisibility(addToCartButton);
        addToCartButton.click();
    }

    public String getSuccessMessageText() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();

    }

}

