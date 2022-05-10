package utils;

import steps.PageInitializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CommonMethods extends PageInitializers {

    public static WebDriver driver;
    public static Select select;
    public static List<WebElement> tableData;

    /**This method opens the browser, maximizes the screen, and navigates to the stored url
    @param "browser"
    @param "url"
    */
    public void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();
    }

    /**
     * This method will send text to any element
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * this method will send keys to any element
     * @param element
     * @param keys
     */
    public static void sendText(WebElement element, Keys keys){
        element.clear();
        element.sendKeys(keys);
    }

    /**
     * This method creates an object of WebDriverWait
     * @return
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * This method creates an Explicit Wait for an element to be clickable
     * @param element
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will click on an element
     * @param element
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * this method creates a JavascriptExecutor object
     * @return
     */
    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * this method uses JSEx to click on an element
     * @param element
     */
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     * this method quits and closes the browser
     */
    public static void tearDown() {
        driver.quit();
    }

    /**
     * this method will switch to a frame based on a WebElement
     * @param element
     */
    public static void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    /**
     * this method will switch to a frame based on its index
     * @param index
     */
    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    /**
     * this method will switch to a frame based on its name or id
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    /**
     * this method will switch back to the default content
     */
    public static void switchToDefaultDefaultContent(){
        driver.switchTo().defaultContent();
    }

    /**
     * this method will select a value from a dropdown menu based on its text
     * @param element
     * @param textToSelect
     */
    public static void selectDdValue(WebElement element, String textToSelect) {
        select = new Select(element);
        select.selectByVisibleText(textToSelect);
    }

    /**
     * this method will select a value from a dropdown menu based on its index
     * @param element
     * @param index
     */
    public static void selectDdValue(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * this method will return a List of WebElements of Table Data
     * @param xpath
     * @return
     */
    public static List<WebElement> getTableData (String xpath){
        List<WebElement> tableData = driver.findElements(By.xpath(xpath));
        return tableData;
    }

    /**
     * this method will get a List of WebElements from a table and click on an element with matching text
     * @param xpath
     * @param str
     */
    public static void selectDay(String xpath, String str){
        getTableData(xpath);
        for(WebElement element:tableData){
            if(element.getText().equals(str)){
                element.click();
            }
        }
    }
}
