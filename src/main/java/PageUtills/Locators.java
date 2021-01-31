package PageUtills;

import lombok.Getter;

public enum Locators {
    ID("id"), CSS("css"), XPATH("xpath"), CLASS("class");
    @Getter
    String locator;

    Locators(String locatorName) {
        this.locator = locatorName;
    }
}
