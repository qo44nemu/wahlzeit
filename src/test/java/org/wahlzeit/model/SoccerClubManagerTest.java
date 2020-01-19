package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.soccer.SoccerClub;
import org.wahlzeit.model.soccer.SoccerClubManager;
import org.wahlzeit.model.soccer.SoccerClubType;

public class SoccerClubManagerTest {

    private SoccerClubType bayernMuenchen;
    private SoccerClubType bundesliga;
    private SoccerClubType dfl;

    private SoccerClubType barcelona;
    private SoccerClubType primeraDivision;
    private SoccerClubType rfef;

    private SoccerClubManager manager;

    @Before
    public void setup() {
        dfl = new SoccerClubType("Deutscher Fußball-Bund", 1900);
        bundesliga = new SoccerClubType("Fußball-Bundesliga", 1962, dfl);
        bayernMuenchen = new SoccerClubType("FC Bayern München", 1900, bundesliga);

        rfef = new SoccerClubType("Real Federación Española de Fútbol", 1913);
        primeraDivision = new SoccerClubType("Primera Division", 1929, rfef);
        barcelona = new SoccerClubType("FC Barcelona", 1929, primeraDivision);
        manager = SoccerClubManager.getInstance();
        manager.addSoccerClubType(dfl);
        manager.addSoccerClubType(bundesliga);
        manager.addSoccerClubType(bayernMuenchen);
        manager.addSoccerClubType(rfef);
        manager.addSoccerClubType(primeraDivision);
        manager.addSoccerClubType(barcelona);
    }

    @Test
    public void testCreateClubWithValidType() {
        SoccerClub club = manager.createSoccerClub("FC Bayern München");
        Assert.assertEquals(club.getType(), bayernMuenchen);
        club = manager.createSoccerClub("FC Barcelona");
        Assert.assertEquals(club.getType(), barcelona);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateClubWithInvalidType() {
        SoccerClub club = manager.createSoccerClub("FC Bayern Muenchen");
    }

    @Test
    public void testGetInstance() {
        Assert.assertSame(manager, SoccerClubManager.getInstance());
    }

}
