package org.wahlzeit.services.mailing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.EmailAddressTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({EmailServiceTest.class, EmailAddressTest.class})
public class EmailServiceTestSuit {
}

