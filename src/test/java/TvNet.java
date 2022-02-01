import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.CommentPage;
import pageobject.pages.HomePage;

import java.util.List;

public class TvNet {
//    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
//
//    private final By ARTICLE = By.tagName("article");
//    private final By TITLE = By.xpath(".//span[contains(@class, 'list-article__headline')]");
//    private final By COMMENTS = By.xpath(".//span[contains(@class, 'article__comment')]");
//    private final By LANGUAGE = By.xpath(".//a[contains(@href, 'rus.tvnet')]");


    private final By COMMENTS_BTN = By.xpath(".//a[contains(@class, 'item--comments')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 5;

    private BaseFunc baseFunc;

    @Test
    public void firstTest() {
        LOGGER.info("This test is checking title and comments count on home/article/comments page");

        baseFunc = new BaseFunc();
        baseFunc.openPage("https://www.tvnet.lv/");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

//

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);

        //ARTICLE PAGE

        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentCount = articlePage.getCommentsCount();


        LOGGER.info("Asserting titles");
        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong Title!");
        LOGGER.info("Asserting comments");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "Wrong Comments Count!");

//        articlePage.openCommentsPage();
        CommentPage commentPage = articlePage.openCommentsPage();

//        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://tvnet.lv");
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
//
//        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
//        acceptBtn.click();
//
//        List<WebElement> articlesCount = driver.findElements(ARTICLE);
//        List<WebElement> commentsCount = driver.findElements(COMMENTS);
//        for (int i = 0; i < articlesCount.size() && i < commentsCount.size(); i++) {
//            WebElement homePageArticle = articlesCount.get(i);
//            WebElement homePageComments = commentsCount.get(i);
//
//           String articles = homePageArticle.findElement(TITLE).getText();
//           String comments = homePageComments.findElement(COMMENTS).getText();
//
//            List<WebElement> homePageArticles = driver.findElements(ARTICLE);
//            WebElement article = homePageArticles.get(2);
//
//            int homePageCommentsCount = 0;
//            if (!comments.isEmpty()) {
//                homePageCommentsCount = parseCommentCountOne(comments.getText());


//                System.out.println(articles + homePageCommentsCount);
            }
           //homePageArticle.getText();




            //System.out.println(articleTitles);


//        List<WebElement> articles = driver.findElements(ARTICLE);
//        WebElement article = articles.get(2);
//        //String homePageTitle = article.findElement(TITLE).getText();
//
//        int homePageCommentsCount = 0;
//        if (!article.findElements(COMMENTS).isEmpty()) {
//            homePageCommentsCount = parseCommentCountOne(article.findElement(COMMENTS).getText());
//        }
//
//        article.click();
//
//        List<WebElement> articleComments = driver.findElements(COMMENTS_BTN);
//        WebElement comment = articleComments.get(0);
//        comment.click();
//
//        System.out.println(articles + " " + homePageCommentsCount);
//        //System.out.println(articles);
//
//
//
//
//    }
//
//    private int parseCommentCountOne(String textToParse) {
//        textToParse = textToParse.substring(1, textToParse.length() - 1);
//        return Integer.parseInt(textToParse);
//    }



    }
