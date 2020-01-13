package org.wahlzeit.model.soccer;

import org.wahlzeit.model.PhotoManager;

@PatternInstance(
        patternName = "Singleton",
        participants = {"SoccerPhotoManager"}
)
public class SoccerPhotoManager extends PhotoManager {

    /**
     * singleton instance
     */
    private static final SoccerPhotoManager instance = new SoccerPhotoManager();

}
