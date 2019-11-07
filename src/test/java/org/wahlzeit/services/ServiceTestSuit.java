package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTestSuit;

@RunWith(Suite.class)
@Suite.SuiteClasses({LogBuilderTest.class, EmailServiceTestSuit.class})
public class ServiceTestSuit {
}
