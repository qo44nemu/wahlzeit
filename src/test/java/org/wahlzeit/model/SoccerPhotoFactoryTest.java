package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.*;

public class SoccerPhotoFactoryTest {
    @ClassRule
    public static SysConfigProvider sysConfigProvider = new SysConfigProvider();
    @ClassRule
    public static WebFormHandlerProvider webFormHandlerProvider = new WebFormHandlerProvider();

    @Rule
    public TestRule chain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider()).
            around(new UserSessionProvider());

    @Test(expected = IllegalStateException.class)
    public void testSetInstanceWhenAlreadySet() {
        SoccerPhotoFactory factory = SoccerPhotoFactory.getInstance();
        SoccerPhotoFactory.setInstance(factory);
    }

    @Test
    public void testCreatePhotoWithoutId() {
        SoccerPhotoFactory factory = SoccerPhotoFactory.getInstance();
        SoccerPhoto photo = factory.createPhoto();
        Assert.assertEquals(1, photo.getId().value);
        Assert.assertNull(photo.getForename());
        Assert.assertNull(photo.getSurname());
        Assert.assertNull(photo.getClub());
    }

    @Test
    public void testCreatePhotoWithId() {
        SoccerPhotoFactory factory = SoccerPhotoFactory.getInstance();
        PhotoId id = new PhotoId(12);
        SoccerPhoto photo = factory.createPhoto(id);
        Assert.assertEquals(id, photo.getId());
        Assert.assertNull(photo.getForename());
        Assert.assertNull(photo.getSurname());
        Assert.assertNull(photo.getClub());
    }

    @Test
    public void testCreateSoccerPhoto() {
        SoccerPhotoFactory factory = SoccerPhotoFactory.getInstance();
        PhotoId id = new PhotoId(12);
        String forename = "forename";
        String surname = "surname";
        String club = "club";

        SoccerPhoto photo = factory.createPhoto(id, forename, surname, club);
        Assert.assertEquals(id, photo.getId());
        Assert.assertEquals(forename, photo.getForename());
        Assert.assertEquals(surname, photo.getSurname());
        Assert.assertEquals(club, photo.getClub());
    }
}
