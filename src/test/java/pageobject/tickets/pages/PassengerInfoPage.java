package pageobject.tickets.pages;

import model.reservations.Reservation;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.math.BigDecimal;
import java.util.List;

public class PassengerInfoPage {
    private final By INFO_TEXT = By.xpath(".//span[@class = 'bTxt']");
    private final By RESPONSE_BLOCK = By.id("response");
    private final By BOOK_BTN = By.id("book2");

    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By LUGGAGE = By.id("BUGS");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@style = 'cursor: pointer;']");

    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getAirports() {
        return baseFunc.findElements(INFO_TEXT);
    }

    public void submitPassengerInfo(Reservation reservation) {
        baseFunc.type(NAME, reservation.getName());
        baseFunc.type(SURNAME, reservation.getSurname());
        baseFunc.type(DISCOUNT, reservation.getDiscount());
        baseFunc.type(ADULTS, reservation.getAdults());
        baseFunc.type(CHILDREN, reservation.getChildren());
        baseFunc.type(LUGGAGE, reservation.getBugs());
        baseFunc.select(FLIGHT, reservation.getFullDate());
        baseFunc.click(GET_PRICE_LINK);
    }

    public String getName() {
        return baseFunc.getText(RESPONSE_BLOCK, INFO_TEXT).replaceAll("!", "");
    }

    public BigDecimal getPrice() {
        String fullText = baseFunc.getText(RESPONSE_BLOCK);
        String price = StringUtils.substringBetween(fullText, "for ", " EUR");
        return new BigDecimal(price);
    }

    public SeatsPage book() {
        baseFunc.click(BOOK_BTN);
        return new SeatsPage(baseFunc);
    }
}
