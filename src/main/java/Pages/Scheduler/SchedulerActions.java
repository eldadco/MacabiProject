package Pages.Scheduler;

import PageUtills.Locators;
import Pages.BasePage;
import org.openqa.selenium.WebElement;

public class SchedulerActions extends BasePage {
    public SchedulerActions() {
    }

    public void requestService(String typeOfService, String date) throws InterruptedException {
        this.seleniumInfra.switchToTheNewTab();
        this.chooseService(typeOfService);
        this.chooseDate(date);
        this.chooseNesZiyona();
    }

    private void chooseService(String typeOfService) {
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), SchedulerLocators.openClinicsMenu, null, null);
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), String.format(SchedulerLocators.dentDoctorOption, typeOfService), null, null);
    }

    private void chooseNesZiyona() throws InterruptedException {
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), SchedulerLocators.locationInput, null, null);
        this.seleniumInfra.write(Locators.CSS.getLocator(), SchedulerLocators.locationInput, null, null, "נס");
        Thread.sleep(4000);
        this.seleniumInfra.downAndEnter(this.seleniumInfra.findElem(Locators.CSS.getLocator(), SchedulerLocators.locationInput, null));
    }

    private void chooseDate(String date) {
        this.seleniumInfra.clickElement(Locators.CSS.getLocator(), SchedulerLocators.dateChoserInput, null, null);
        this.seleniumInfra.write(Locators.CSS.getLocator(), SchedulerLocators.dateChoserInput, null, null, date);

    }



}
