package Pages.MacabiDentPage;

import PageUtills.Locators;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MacabiDentActions extends BasePage {
    public MacabiDentActions() {
    }

    public void enterToGoldMacabiTab() throws InterruptedException {
        Thread.sleep(7000);
        this.seleniumInfra.clickElement(Locators.XPATH.getLocator(), MacabiDentLocators.goldMacabiTab,null, null);
        By selectedTab = new By.ByXPath(MacabiDentLocators.goldMacabiTabSelected);
        this.seleniumInfra.waitToElementToBeVisible(selectedTab);
    }


    public void enterToServiceLocationLink() throws InterruptedException {
        Thread.sleep(5000);
        WebElement link = this.seleniumInfra.findElem(Locators.CSS.getLocator(), MacabiDentLocators.serviceLocation,null);
        this.seleniumInfra.scrollByOption("toElement",link);
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), MacabiDentLocators.serviceLocation,null,null);
        this.seleniumInfra.switchToTheNewTab();
        this.seleniumInfra.waitToElementToBeVisible(new By.ByXPath(MacabiDentLocators.toWhereYouCanArrive));

    }
}
