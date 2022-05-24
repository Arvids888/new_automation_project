package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private final Logger LOOGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BaseFunc() {
        LOOGER.info("Starting and maximizing browser window");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
//        javascriptExecutor = (JavascriptExecutor) ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);");

    }

    public void openPage(String url) {
        LOOGER.info("Opening page by URL : " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public void click(By locator) {
        LOOGER.info("Clicking on element by: " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(WebElement element) {
        LOOGER.info("Clicking on web element");
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElement(By parent, By child) {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
    }

    public List<WebElement> findElements(By locator) {
        LOOGER.info("Getting list of elements by: " + locator);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> findElements(By parent, By child) {
        LOOGER.info("Getting list of elements by: " + parent + child);
        return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, child));
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        LOOGER.info("Getting all child elements");
        return parent.findElements(child);
    }

    public String getText(WebElement parent, By child) {
        LOOGER.info("Getting text for child element by locator");
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child)).getText();
    }

    public String getText(By parent, By child) {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child)).getText();
    }

    public String getText(By locator) {
        LOOGER.info("Getting text from web element");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public String getComments(By locator) {
        String getComments = driver.findElement(locator).getText();
        return getComments;
    }

    public void select(By dropdown, String text) {
        LOOGER.info("Selecting " + text + " from drop down by locator: " + dropdown);
        Select select= new Select(findElement(dropdown));
        select.selectByVisibleText(text);
    }

    public void type(By locator, String text) {
        LOOGER.info("Typing " + text + " into " + locator);
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    public void type(By locator, int text) {
        type(locator, String.valueOf(text));
    }

    public void waitForElementsCountToBeMoreThan(By locator, int count) {
        LOOGER.info("Waiting for elements count to be" + count);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
    }

    public By javaScriptScroll(By locator) {
        js.executeScript("arguments[0].scrollIntoView(true);", locator);
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        return null;
    }

    @AfterEach
    public void closeBrowser() {
        LOOGER.info("Closing browser window");
        if (driver != null) {
            driver.close();
        }
    }
}
