package model.reservations;

import org.apache.commons.lang3.RandomStringUtils;

public class Reservation {
    private long id;
    private String name;
    private String surname;
    private String afrom;
    private String ato;
    private int bugs;
    private String discount;
    private int children;
    private String flight;
    private int adults;
    private int seat;
    private String fullDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.equals("random") ? RandomStringUtils.randomAlphabetic(10) : name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAfrom() {
        return afrom;
    }

    public void setAfrom(String afrom) {
        this.afrom = afrom;
    }

    public String getAto() {
        return ato;
    }

    public void setAto(String ato) {
        this.ato = ato;
    }

    public int getBugs() {
        return bugs;
    }

    public void setBugs(int bugs) {
        this.bugs = bugs;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getFlight() {
        return flight.equals("none") ? 0 : Integer.parseInt(flight);
//        if (flight.equals("none")) {
//            return 0;
//        }
//        return Integer.parseInt(flight);
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }
}
