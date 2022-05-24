package pageobject.tvnet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

public class ArticlePage {
    private final By ARTICLE = By.id("article");
    private final By TITLE = By.id("article-headline");
    private final By SUPER_TITLE = By.id("article-superheader");
//    private final By TITLE = By.xpath(".//h1[contains(@class, 'article-headline')]");
//    private final By SUPER_TITLE = By.xpath(".//h1[contains(@class, 'article-superheader')]");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'article-share__item')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

//    JavascriptExecutor javascriptExecutor;

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");

//        try {
//            String getTitles = baseFunc.findElements(ARTICLE, TITLE).isEmpty();
//        }catch (NoSuchElementException n)
//        {
//            String getTitles = baseFunc.findElement(SUPER_TITLE).getText();
        if (!baseFunc.findElements(ARTICLE, TITLE).isEmpty()) {
           return baseFunc.getText(ARTICLE, TITLE);
        } else {
            return baseFunc.getText(ARTICLE, SUPER_TITLE);

//        WebElement titleElement = baseFunc.findElement(TITLE);
//        baseFunc.javaScriptScroll(titleElement);
//        ((JavascriptExecutor) baseFunc.driver).executeScript("arguments[0].scrollIntoView(false);", titleElement);
        }
//        return
    }

    public By scrollCommentsCount() {
        return baseFunc.javaScriptScroll(COMMENTS);
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
