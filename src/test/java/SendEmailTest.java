/******************************************************************************
 * This piece of work is to enhance EmailApp project functionality.           *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      SendEmailTest.java                                              *
 * Created:   28/10/2021, 15:39                                               *
 * Modified:  28/10/2021, 15:39                                               *
 *                                                                            *
 * Copyright (c)  2021.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SendEmailTest {

    @BeforeEach
    void setUp() {
        Log.info("Starting Utility Email Test");
    }

    @AfterEach
    void tearDown() {
        Log.info("Utility Email Test complete");
    }

    @Test
    @DisplayName("Unit Testing SendMail")
    void sendMail() {
        String actual;
        String expected;
        actual = SendEmail.sendMail("support@aerosimo.com", "Test Email", "This is a test email. With thousands of potential renderings, spam filters on high alert, and the constant risk of broken links, email testing is not a nice-to-have but it is a need-to-have.","");
        assertNotNull(actual, "Checking that the email response is not null");
        expected = "Email Sent Successfully";
        Assertions.assertEquals(expected, actual, "This should match a the success message from the mail api");
    }
}