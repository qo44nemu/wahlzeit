package org.wahlzeit.model.soccer;

import java.util.HashMap;

public class SoccerClubManager {
    private static SoccerClubManager instance = null;
    private HashMap<String, SoccerClub> clubs = new HashMap<>();
    private HashMap<String, SoccerClubType> clubTypes = new HashMap<>();

    public synchronized static SoccerClubManager getInstance() {
        if (instance == null) {
            instance = new SoccerClubManager();
        }
        return instance;
    }

    public SoccerClub createSoccerClub(String typeName) {
        assertIsValidClubName(typeName);
        SoccerClubType type = getSoccerClubType(typeName);
        SoccerClub club = type.createInstance();
        clubs.put(club.getId(), club);
        return club;
    }

    public void addSoccerClubType(SoccerClubType type) {
        clubTypes.put(type.getName(), type);
    }

    private SoccerClubType getSoccerClubType(String typeName) {
        return clubTypes.get(typeName);
    }

    private void assertIsValidClubName(String typeName) {
        if (!clubTypes.containsKey(typeName)) {
            throw new IllegalArgumentException("Invalid SoccerClubType name");
        }
    }
}
