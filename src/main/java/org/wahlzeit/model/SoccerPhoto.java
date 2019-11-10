package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class SoccerPhoto extends Photo {

    public static final String FORENAME = "forename";

    String forename;
    String surname;
    String club;


    public SoccerPhoto() {
        super();
    }

    public SoccerPhoto(PhotoId id) {
        super(id);
    }

    public SoccerPhoto(PhotoId id, String forename, String surname, String club) {
        super(id);
        this.forename = forename;
        this.surname = surname;
        this.club = club;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

}
