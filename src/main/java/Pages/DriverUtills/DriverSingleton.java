package Pages.DriverUtills;

import SeleniumInfra.SeleniumInfraStructure;

public class DriverSingleton {
    public SeleniumInfraStructure seleniumInfra;
    private static DriverSingleton instance = null;

    private DriverSingleton() {
        this.seleniumInfra = new SeleniumInfraStructure();

    }

    public static DriverSingleton getInstance() {
        if (instance == null)
            instance = new DriverSingleton();

        return instance;
    }


}
