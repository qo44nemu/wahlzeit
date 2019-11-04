/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.services.mailing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.EmailAddress;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailServiceTest {

    private EmailService emailService = null;
    private EmailAddress validAddress = null;

    @Before
    public void setup() {
        emailService = EmailServiceManager.getDefaultService();
        validAddress = EmailAddress.getFromString("test@test.de");
    }

    @Test
    public void testSendInvalidEmailWithoutBcc() {
        try {
            // No receiver
            assertFalse(emailService.sendEmailIgnoreException(validAddress, null, "lol", "hi"));
            // No sender
            assertFalse(emailService.sendEmailIgnoreException(null, validAddress, "lol", "body"));
            // No header
            assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "body"));
            // No body
            assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", null));
        } catch (Exception ex) {
            Assert.fail("Silent mode does not allow exceptions");
        }
    }

    @Test
    public void testSendValidEmail() {
        try {
            assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", "test"));
            assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, validAddress, "hi", "test"));
        } catch (Exception ex) {
            Assert.fail("Silent mode does not allow exceptions");
        }
    }

    @Test
    public void testSendInvalidEmailWithBcc() {
        try {
            // No receiver
            assertFalse(emailService.sendEmailIgnoreException(validAddress, null, validAddress, "lol", "hi"));
            // No sender
            assertFalse(emailService.sendEmailIgnoreException(null, validAddress, validAddress, "lol", "body"));
            // No header
            assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, validAddress, null, "body"));
            // No body
            assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, validAddress, "hi", null));
            //
            assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "hi", "body"));
        } catch (Exception ex) {
            Assert.fail("Silent mode does not allow exceptions");
        }
    }
}