package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private final Logger LOOGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    WebDriverWait wait;
//    JavascriptExecutor javascriptExecutor;

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
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        LOOGER.info("Getting list of elements by: " + locator);
        return driver.findElements(locator);
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        LOOGER.info("Getting all child elements");
        return parent.findElements(child);
    }

    public String getText(WebElement parent, By child) {
        LOOGER.info("Getting text for child element by locator");
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

//    public void javaScriptScroll(List<WebElement> element) {
////        javascriptExecutor = (JavascriptExecutor) ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);");
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
//    }

//    public String javaScript() {
//
//    }

    public void closeBrowser() {
        LOOGER.info("Closing browser window");
        if (driver != null) {
            driver.close();
        }
    }
}
