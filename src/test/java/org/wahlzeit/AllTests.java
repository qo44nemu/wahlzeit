package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuit;
import org.wahlzeit.model.ModelTestSuit;
import org.wahlzeit.services.ServiceTestSuit;
import org.wahlzeit.utils.UtilsTestSuit;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HandlersTestSuit.class,
        ModelTestSuit.class,
        ServiceTestSuit.class,
        UtilsTestSuit.class
})
public class AllTests {
}
