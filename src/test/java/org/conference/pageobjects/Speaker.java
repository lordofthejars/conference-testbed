package org.conference.pageobjects;

public class Speaker {

    private String firstname;
    private String surname;
    private String twitter;

    public Speaker(String firstname, String surname, String twitter) {
        this.firstname = firstname;
        this.surname = surname;
        this.twitter = twitter;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getTwitter() {
        return twitter;
    }
}
