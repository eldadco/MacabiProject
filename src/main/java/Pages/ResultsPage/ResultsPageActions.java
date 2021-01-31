package Pages.ResultsPage;

import PageUtills.Locators;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPageActions extends BasePage {
    public ResultsPageActions() {
    }

    public void moveSlider() {
        WebElement slider = this.seleniumInfra.findElem(Locators.CSS.getLocator(), ResultsPageLocators.slider, null);
        this.seleniumInfra.moveSliderToTheHighestPoint(slider);

    }

    public void chooseDays(int[] days) {
        try {
            for (int day : days) {
                this.seleniumInfra.clickElement(Locators.CSS.getLocator(), String.format(ResultsPageLocators.day, day), null, null);

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void chooseClinic(String clinicLocation) {
        while (this.seleniumInfra.isElementExists(Locators.CSS.getLocator(), ResultsPageLocators.nextButton, null)) {
            List<WebElement> clinicCards = this.seleniumInfra.findElementListBy(Locators.CSS.getLocator(), ResultsPageLocators.clinicCard);
            for (WebElement clinic : clinicCards) {
                String title = this.seleniumInfra.getTextFromElement(Locators.CSS.getLocator(), ResultsPageLocators.clinicName, null, clinic);
                if (title.contains(clinicLocation)) {
                    this.seleniumInfra.clickElement(Locators.CSS.getLocator(), ResultsPageLocators.scheduleMeetingButton, null, clinic);
                }
            }
            this.moveToNextPage();
            this.seleniumInfra.waitToElementToBeVisible(By.cssSelector(ResultsPageLocators.slider));
        }

    }

    private void moveToNextPage() {
        WebElement nextButton = this.seleniumInfra.findElem(Locators.CSS.getLocator(), ResultsPageLocators.nextButton, null);
        this.seleniumInfra.scrollByOption("toELement", nextButton);
        this.seleniumInfra.clickElement(null, null, nextButton, null);

    }

}
