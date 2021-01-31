package Pages.HomePage;

import PageUtills.Locators;
import Pages.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageActions extends BasePage {
    public HomePageActions()
    {}


    public void scrollToFeatureByElement(WebElement element)
    {
        this.seleniumInfra.scrollByOption("toElement", element);
    }
    public void enterToMacabiDent() throws InterruptedException {

        WebElement macabiDent = this.seleniumInfra.findElem(Locators.CSS.getLocator(), HomePage.macabiDent,null);
        this.scrollToFeatureByElement(macabiDent);
        this.seleniumInfra.clickElement(null,null,macabiDent,null);
        Thread.sleep(4000);
    }

    public void scrollToBottomOfThePage()
    {
        this.seleniumInfra.scrollByOption("untilDown",null);
    }
}
