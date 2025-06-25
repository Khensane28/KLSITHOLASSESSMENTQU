package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage {
    WebDriver driver;

    @FindBy(xpath = "//h2[@class='product-title']/a[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputerLink;

    public DesktopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectBuildYourOwnComputer() {
        buildYourOwnComputerLink.click();
    }
}
