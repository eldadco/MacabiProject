package Tests;

import Pages.DriverUtills.DriverSingleton;
import SeleniumInfra.SeleniumInfraStructure;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    private final SeleniumInfraStructure seleniumInfra = DriverSingleton.getInstance().seleniumInfra;

    @BeforeClass
    public void beforeClassMethod() {
        this.seleniumInfra.getUrl("https://www.maccabi4u.co.il/14-he/Maccabi.aspx");
        this.seleniumInfra.wait(5);
    }

    @AfterSuite
    public void afterSuiteMethod() {
        this.seleniumInfra.close();
        this.seleniumInfra.quit();
    }

}

