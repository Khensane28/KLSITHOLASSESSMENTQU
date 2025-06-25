package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputersPage {


    WebDriver driver;

    @FindBy(xpath = "//img[@alt='Picture for category Desktops']")
    WebElement desktopsImage;

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDesktopsCategory() {
        desktopsImage.click();
    }
}

