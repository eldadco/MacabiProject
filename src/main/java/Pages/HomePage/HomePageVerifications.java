package Pages.HomePage;

import Pages.BasePage;

public class HomePageVerifications extends BasePage {
    public HomePageVerifications() {
    }

    public Boolean isHomePageWasOpened() {
        return this.seleniumInfra.urlValidation("https://automation.herolo.co.il/");

    }

}
