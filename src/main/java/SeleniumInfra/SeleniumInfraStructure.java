package SeleniumInfra;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumInfraStructure {
    protected WebDriver driver;
    protected WebDriverWait waitForElems;
    protected JavascriptExecutor js;
    protected ExpectedConditions conditions;

    public SeleniumInfraStructure() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\p0028867\\Documents\\ChromeDriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.waitForElems = new WebDriverWait(this.driver, 80);
        this.js = (JavascriptExecutor) driver;

    }

    public void getUrl(String url) {
        try {
            this.driver.get(url);
            System.out.println("Selenium-infra success message:\t The requested site has opened successfully");
            Thread.sleep(3000);
            this.driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Selenium-infra error : \t" + e.toString());
        }
    }

    public void moveSliderToTheHighestPoint(WebElement slider) {
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, -130, 0).build().perform();

    }

    public boolean isElementExists(String locatorType, String locatorValue, WebElement fromElement) {
        if (this.findElem(locatorType, locatorValue, fromElement) != null) {
            System.out.println("The element has found successfully");
            return true;
        } else {
            return false;
        }
    }

    public void waitToElementToBeVisible(By elem) {
        this.refresh();
        this.waitForElems.until(ExpectedConditions.visibilityOfElementLocated(elem));
    }
//    public void waitForElementToBeUnVisible(WebElement elem)
//    {
//        this.waitForElems.until(ExpectedConditions.invisibilityOf(elem));
//    }

    public Boolean urlValidation(String url) {
        try {
            Thread.sleep(5000);
            if (this.driver.getCurrentUrl().contains(url)) {
                System.out.println("SeleniumInfra success message : the current url is: " + url);
                return true;
            } else {
                System.out.println("SeleniumInfra failed message : the current url does not contain: " + url);
                System.out.println("The current url is " + this.driver.getCurrentUrl());
                return false;
            }
        } catch (Exception excep) {
            System.out.println("SeleniumInfra exception message : " + excep.toString());
            return false;
        }
    }

    public WebElement findElem(String locatorType, String locatorValue, WebElement fromElement) {

        try {
            if (fromElement == null) {
                switch (locatorType) {
                    case "class":
                        return this.driver.findElement(By.className(locatorValue));
                    case "id":
                        return this.driver.findElement(By.id(locatorValue));
                    case "xpath":
                        return this.driver.findElement(By.xpath(locatorValue));
                    case "css":
                        return this.driver.findElement(By.cssSelector(locatorValue));
                    case "tag":
                        return this.driver.findElement(By.tagName(locatorValue));
                    default:
                        System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                        break;
                }
            } else {
                switch (locatorType) {
                    case "class":
                        return fromElement.findElement(By.className(locatorValue));
                    case "id":
                        return fromElement.findElement(By.id(locatorValue));
                    case "xpath":
                        return fromElement.findElement(By.xpath(locatorValue));
                    case "css":
                        return fromElement.findElement(By.cssSelector(locatorValue));
                    case "tag":
                        return fromElement.findElement(By.tagName(locatorValue));
                    default:
                        System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                        break;
                }
            }
        } catch (InvalidSelectorException excep) {
            System.out.println("Selenium-infra error : \t" + "invalid selector exception by locatorType: " + locatorType + " and locator value : " + locatorValue);
        } catch (NoSuchElementException excep) {
            System.out.println("Selenium-infra error : No such Element Exception by locatorType: "
                    + locatorType + " and locator value : " + locatorValue);

        } catch (ElementNotVisibleException excep) {

            System.out.println("Selenium-infra error : element not visible exception by locatorType: " + locatorType + " and locator value : " + locatorValue);
        }
        return null;

    }

    public List<WebElement> findElementListBy(String locatorType, String locatorValue) {

        try {

            switch (locatorType) {
                case "class":
                    return this.driver.findElements(By.className(locatorValue));
                case "id":
                    return this.driver.findElements(By.id(locatorValue));
                case "xpath":
                    return this.driver.findElements(By.xpath(locatorValue));
                case "css":
                    return this.driver.findElements(By.cssSelector(locatorValue));
                case "tag":
                    return this.driver.findElements(By.tagName(locatorValue));
                default:
                    System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                    break;
            }
        } catch (NoSuchElementException | ElementNotVisibleException except) {
            System.out.println("Selenium-infra error : \t" + except.toString());
        }
        return null;

    }


    public String getTextFromElement(String locatorType, String locatorValue, WebElement elem, WebElement fromElement) {
        try {
            if (elem == null) {
                elem = this.findElem(locatorType, locatorValue, fromElement);
            }
            return elem.getText();
        } catch (Exception excep) {
            System.out.println("seleniumInfra error " + excep.toString());
            return "getTextFromElement function failed";
        }
    }


    public void downAndEnter(WebElement element) {
        try {
            element.sendKeys(Keys.DOWN);
            element.sendKeys(Keys.ENTER);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void clickElement(String locatorType, String locatorValue, WebElement elem, WebElement fromElement) {
        try {
            Thread.sleep(2000);
            if (elem == null) {
                elem = this.findElem(locatorType, locatorValue, fromElement);
            }
            elem.click();
            System.out.println("Selenium-infra success message:\tThe element was successfully clicked");
        } catch (ElementNotVisibleException | ElementNotSelectableException | InterruptedException excep) {
            System.out.println("Selenium-infra error : \t" + excep.toString());
        }
    }

    public void clickViaJsByCssSelector(String selector)
    {
        this.js.executeScript(String.format("document.querySelector(\"%s\"",selector));
    }
    public void write(String locatorType, String locatorValue, WebElement elem, WebElement fromElement, String text) {
        try {
            if (elem == null) {
                elem = this.findElem(locatorType, locatorValue, fromElement);
            }

            elem.sendKeys(text);
            System.out.println("Selenium-infra success message:\twriting text to the element");
        } catch (ElementNotVisibleException excep) {
            System.out.println("Selenium-infra error : \t" + excep.toString());
        }
    }

    public void wait(int number) {
        this.driver.manage().timeouts().implicitlyWait(number, TimeUnit.SECONDS);
    }

    public void scrollByOption(String option, WebElement element) {
        switch (option) {
            case "toElement": {
                if (element != null) {
                    this.js.executeScript("arguments[0].scrollIntoView(true)", element);
                }
                break;
            }
            case "untilDown": {
                this.js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                break;
            }
        }
    }

    public void refresh() {
        this.driver.navigate().refresh();
    }

    public void closeTabByIndex(int index) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            this.driver.switchTo().window(tabs.get(index));
            this.driver.close();
            this.driver.switchTo().window(tabs.get(index - 1));
        }
    }

    public void switchToTheNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        this.driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void close() {

        this.driver.close();
    }

    public void quit() {
        this.driver.quit();
    }
}
