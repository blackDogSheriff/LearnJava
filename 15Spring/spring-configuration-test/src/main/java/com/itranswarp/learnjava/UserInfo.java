package com.itranswarp.learnjava;

public class UserInfo {
    private Country country;

    public UserInfo(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
