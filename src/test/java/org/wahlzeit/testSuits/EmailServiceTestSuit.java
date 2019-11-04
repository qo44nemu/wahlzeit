package org.wahlzeit.testSuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({EmailServiceTest.class})
public class EmailServiceTestSuit {
}

