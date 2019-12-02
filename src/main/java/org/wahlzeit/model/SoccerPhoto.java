package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class SoccerPhoto extends Photo {

    private String forename;
    private String surname;
    private String club;

    private Location location;

    public SoccerPhoto() {
        super();
    }

    public SoccerPhoto(PhotoId id) throws IllegalArgumentException {
        super(id);
    }

    public SoccerPhoto(PhotoId id, String forename, String surname, String club) throws IllegalArgumentException {
        super(id);
        assertStringNotNullNotEmpty(forename);
        assertStringNotNullNotEmpty(surname);
        assertStringNotNullNotEmpty(club);
        this.forename = forename;
        this.surname = surname;
        this.club = club;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) throws IllegalArgumentException {
        assertStringNotNullNotEmpty(forename);
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws IllegalArgumentException {
        assertStringNotNullNotEmpty(surname);
        this.surname = surname;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) throws IllegalArgumentException {
        assertStringNotNullNotEmpty(club);
        this.club = club;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) throws IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Location can not be null!");
        }
        this.location = location;
    }

}
