package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DatastoreAdapterTest.class,
        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,})
public class ModelTestSuit {
}
