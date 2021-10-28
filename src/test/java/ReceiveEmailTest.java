/******************************************************************************
 * This piece of work is to enhance EmailApp project functionality.           *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ReceiveEmailTest.java                                           *
 * Created:   28/10/2021, 19:28                                               *
 * Modified:  28/10/2021, 19:28                                               *
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

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveEmailTest {

    @BeforeEach
    void setUp() {
        Log.info("Starting Receive Email Test");
    }

    @AfterEach
    void tearDown() {
        Log.info("Receive Email Test complete");
    }

    @Test
    @DisplayName("Unit Testing ReceiveEmail")
    void checkMail() {
        String actual;
        String expected;
        actual = ReceiveEmail.checkMail();
        assertNotNull(actual, "Checking that the email response is not null");
        expected = "Success";
        Assertions.assertEquals(expected, actual, "This should match a the success message from the mail api");
    }
}