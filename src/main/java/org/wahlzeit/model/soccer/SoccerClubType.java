package org.wahlzeit.model.soccer;

import java.util.HashSet;
import java.util.Set;

public class SoccerClubType {
    private String name;
    private int yearOfFoundation;
    private SoccerClubType superType = null;
    protected Set<SoccerClubType> subTypes = new HashSet<>();

    public SoccerClubType(String name, int yearOfFoundation) {
        assertStringNotNullNotEmpty(name);
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
    }

    public SoccerClubType(String name, int yearOfFoundation, SoccerClubType superType) {
        if (superType == null) {
            throw new IllegalArgumentException("Parameter SoccerClubType can not be null!");
        }
        assertStringNotNullNotEmpty(name);
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        superType.addSubType(this);
    }

    public String getName() {
        return name;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public SoccerClubType getSuperType() {
        return superType;
    }

    public void setSuperType(SoccerClubType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type can not be null!");
        }
        this.superType = type;
    }

    public void addSubType(SoccerClubType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type can not be null!");
        }
        type.setSuperType(this);
        subTypes.add(type);
    }

    public SoccerClub createInstance() {
        return new SoccerClub(this);
    }

    public boolean isSubtypeOf(SoccerClubType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter SoccerClubType can not be null!");
        }
        if (superType == null) {
            return false;
        }
        if (superType == type) {
            return true;
        } else {
            return superType.isSubtypeOf(type);
        }
    }

    private void assertStringNotNullNotEmpty(String value) {
        if (value == null) {
            throw new IllegalArgumentException("String can not be null!");
        }
    }
}
