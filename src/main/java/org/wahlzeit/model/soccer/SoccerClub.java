package org.wahlzeit.model.soccer;

import java.util.UUID;

public class SoccerClub {
    private SoccerClubType type;
    private String id;

    public SoccerClub(SoccerClubType type) {
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }

    public SoccerClubType getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
