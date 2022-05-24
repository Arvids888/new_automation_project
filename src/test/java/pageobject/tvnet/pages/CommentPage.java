package pageobject.tvnet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class CommentPage {
    private final By TITLE = By.xpath(".//h1[(@class = 'article-headline')]");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'article-comments')]");
    private final By MORE_COMMENTS = By.xpath(".//button[contains(@id, 'btnLoadmore')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting comment title");
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount() {
        LOGGER.info("Getting comment count");
            String commentsCount = baseFunc.getText(COMMENTS);
            return Integer.parseInt(commentsCount);
    }
}
