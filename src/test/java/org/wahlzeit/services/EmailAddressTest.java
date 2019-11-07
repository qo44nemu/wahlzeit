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

package org.wahlzeit.services;

import org.junit.Assert;
import org.junit.Test;

import javax.mail.internet.InternetAddress;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest {

    /**
     *
     */
    private boolean createEmailAddressIgnoreException(String ea) {
        try {
            EmailAddress.getFromString(ea);
            return true;
        } catch (IllegalArgumentException ex) {
            // creation failed
            return false;
        }
    }

    /**
     *
     */
    @Test
    public void testGetEmailAddressFromString() {
        // invalid email addresses are allowed for local testing and online avoided by Google

        assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
        assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
        assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
        assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
    }

    public void testAsString() {
        String email = "test@test.de";
        EmailAddress address = new EmailAddress(email);
        Assert.assertEquals(address.asString(), email);
    }

    /**
     *
     */
    @Test
    public void testIsValidWithEmptyEmailAddress() {

        assertFalse(EmailAddress.EMPTY.isValid());
    }

    @Test
    public void testIsValidWithValidEmailAddress() {
        EmailAddress address = new EmailAddress("test-email@test.de");
        assertTrue(address.isValid());
    }

    @Test
    public void testIsValidWithNewEmptyEmailAddress() {
        EmailAddress address = new EmailAddress("");

        // New empty email address is valid because isEmpty
        // checks if objects are the same and not if contents are the same
        assertTrue(address.isValid());
    }

    @Test
    public void testIsEqualWithEqualEmails() {
        EmailAddress address = new EmailAddress("test-email@test.de");
        EmailAddress differentAddress = new EmailAddress("test-email@test.de");

        // Equals returns false because objects are different
        Assert.assertFalse(address.isEqual(differentAddress));
    }

    @Test
    public void testIsEqualWithOneEmail() {
        EmailAddress address = new EmailAddress("test-email@test.de");

        // Equals returns true because objects are the same
        assertTrue(address.isEqual(address));
    }

    @Test
    public void testIsEqualWithDifferentEmails() {
        EmailAddress address = new EmailAddress("test-email@test.de");
        EmailAddress differentAddress = new EmailAddress("different-test-email@test.de");

        Assert.assertFalse(address.isEqual(differentAddress));
    }

    @Test
    public void testAsInternetAddressWithValidEmailAddress() {
        EmailAddress address = new EmailAddress("test-address@test.de");
        InternetAddress internetAddress = address.asInternetAddress();
        Assert.assertNotNull(internetAddress);
    }

    @Test
    public void testAsInternetAddressWithInvalidEmailAddress() {
        EmailAddress address = new EmailAddress("test-address@test@.de");
        InternetAddress internetAddress = address.asInternetAddress();
        Assert.assertNull(internetAddress);
    }
}

