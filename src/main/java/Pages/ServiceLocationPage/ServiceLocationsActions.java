package Pages.ServiceLocationPage;

import PageUtills.Locators;
import Pages.BasePage;
import org.openqa.selenium.WebElement;

public class ServiceLocationsActions extends BasePage {
    public ServiceLocationsActions()
    {}



    public void searchAddress(String city) throws InterruptedException {
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), ServiceLocationPageLocators.address,null,null);

        this.seleniumInfra.write(Locators.CSS.getLocator(), ServiceLocationPageLocators.address,null,null,city);
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), ServiceLocationPageLocators.searchButton,null,null);
        Thread.sleep(3000);
    }


}

