package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'article-headline')]");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'article-share__item')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    JavascriptExecutor javascriptExecutor;

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        WebElement titleElement = baseFunc.findElement(TITLE);
//        baseFunc.javaScriptScroll(titleElement);
        ((JavascriptExecutor) baseFunc.driver).executeScript("arguments[0].scrollIntoView(false);", titleElement);
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comment count");

        if (baseFunc.findElements(COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCount = baseFunc.getText(COMMENTS);
            return Integer.parseInt(commentsCount);
        }
    }

    public CommentPage openCommentsPage() {
        LOGGER.info("Opening article comments page");
        baseFunc.click(COMMENTS);
        return new CommentPage(baseFunc);
    }
}
