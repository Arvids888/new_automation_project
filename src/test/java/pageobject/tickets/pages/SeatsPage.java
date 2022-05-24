package pageobject.tickets.pages;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

public class SeatsPage {
    private final By BOOK_BTN = By.id("book3");
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_NR = By.xpath(".//div[@class = 'line']");

    private BaseFunc baseFunc;

    public SeatsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat(int nr) {
        WebElement seat = findSeat(nr);
        Assertions.assertNotNull(seat, "Can't find seat with Nr. " + nr);
        baseFunc.click(seat);
    }

    public int getSeatNr() {
        return Integer.parseInt(StringUtils.substringAfterLast(baseFunc.getText(SEAT_NR), "is: "));
    }

    public SuccessPage book() {
        baseFunc.click(BOOK_BTN);
        return new SuccessPage(baseFunc);
    }

    private WebElement findSeat(int nr) {
        baseFunc.waitForElementsCountToBeMoreThan(SEAT, 10);
        for (WebElement we : baseFunc.findElements(SEAT)) {
            if (Integer.parseInt(we.getText()) == nr) {
                return we;
//                baseFunc.click(we);
//                break;
            }
        }

        return null;
    }
}
