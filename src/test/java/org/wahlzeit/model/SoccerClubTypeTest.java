package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.soccer.SoccerClubType;

public class SoccerClubTypeTest {

    private SoccerClubType bayernMuenchen;
    private SoccerClubType bundesliga;
    private SoccerClubType dfl;

    private SoccerClubType barcelona;
    private SoccerClubType primeraDivision;
    private SoccerClubType rfef;

    @Before
    public void setup() {
        dfl = new SoccerClubType("Deutscher Fußball-Bund", 1900);
        bundesliga = new SoccerClubType("Fußball-Bundesliga", 1962, dfl);
        bayernMuenchen = new SoccerClubType("FC Bayern München", 1900, bundesliga);

        rfef = new SoccerClubType("Real Federación Española de Fútbol", 1913);
        primeraDivision = new SoccerClubType("Primera Division", 1929, rfef);
        barcelona = new SoccerClubType("FC Barcelona", 1929, primeraDivision);

    }

    @Test
    public void testIsSubtypeOf(){
        Assert.assertTrue(bayernMuenchen.isSubtypeOf(bundesliga));
        Assert.assertTrue(bayernMuenchen.isSubtypeOf(dfl));
        Assert.assertTrue(bundesliga.isSubtypeOf(dfl));

    }
}
