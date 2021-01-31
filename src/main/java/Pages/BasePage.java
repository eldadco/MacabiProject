package Pages;

import Pages.DriverUtills.DriverSingleton;
import SeleniumInfra.SeleniumInfraStructure;

abstract public class BasePage {
    protected SeleniumInfraStructure seleniumInfra = DriverSingleton.getInstance().seleniumInfra;

    public BasePage() {
    }

}
