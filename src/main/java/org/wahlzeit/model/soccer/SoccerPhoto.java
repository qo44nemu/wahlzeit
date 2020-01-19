package org.wahlzeit.model.soccer;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.Location;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

@Entity
public class SoccerPhoto extends Photo {
    private String forename;
    private String surname;
    private SoccerClub club;
    private Location location;

    public SoccerPhoto() {
        super();
    }

    public SoccerPhoto(PhotoId id) throws IllegalArgumentException {
        super(id);
    }

    public SoccerPhoto(PhotoId id, String forename, String surname) throws IllegalArgumentException {
        super(id);
        assertStringNotNullNotEmpty(forename);
        assertStringNotNullNotEmpty(surname);
        this.forename = forename;
        this.surname = surname;

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

    public SoccerClub getClub() {
        return club;
    }

    public void setClub(SoccerClub club) throws IllegalArgumentException {
        if (club == null) {
            throw new IllegalArgumentException("SoccerClub can not be null!");
        }
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

    private void assertStringNotNullNotEmpty(String value) {
        if (value == null) {
            throw new IllegalArgumentException("String can not be null!");
        }

    }
}
