package org.wahlzeit.model.soccer;

import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class SoccerPhotoFactory extends PhotoFactory {
    private static final Logger log = Logger.getLogger(SoccerPhotoFactory.class.getName());

    private static SoccerPhotoFactory instance = null;

    /**
     *
     */
    protected SoccerPhotoFactory() {
        // do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized SoccerPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic SoccerPhotoFactory").toString());
            setInstance(new SoccerPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    public static synchronized void setInstance(SoccerPhotoFactory soccerPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize SoccerPhotoFactory twice");
        }

        instance = soccerPhotoFactory;
    }

    /**
     * @methodtype factory
     */
    public SoccerPhoto createPhoto() {
        return new SoccerPhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    public SoccerPhoto createPhoto(PhotoId id) {
        return new SoccerPhoto(id);
    }

    public SoccerPhoto createPhoto(PhotoId id, String forename, String surname) {
        return new SoccerPhoto(id, forename, surname);
    }
}
