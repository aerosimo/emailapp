/******************************************************************************
 * This piece of work is to enhance EmailApp project functionality.           *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      LogTest.java                                                    *
 * Created:   28/10/2021, 15:33                                               *
 * Modified:  28/10/2021, 15:33                                               *
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
import org.junit.jupiter.api.Test;

class LogTest {

    @BeforeEach
    void setUp() {
        Log.info("Starting Log Test");
    }

    @AfterEach
    void tearDown() {
        Log.info("Log Test complete");
    }
    @Test
    @DisplayName("Checking Info Level Logs")
    void info() {
        Log.info("Designates informational messages that highlight the progress of the application at coarse-grained level.");
    }

    @Test
    @DisplayName("Checking Warn Level Logs")
    void warn() {
        Log.warn("Designates potentially harmful situations.");
    }

    @Test
    @DisplayName("Checking Error Level Logs")
    void error() {
        Log.error("Designates error events that might still allow the application to continue running.");
    }

    @Test
    @DisplayName("Checking Fatal Level Logs")
    void fatal() {
        Log.fatal("Designates very severe error events that will presumably lead the application to abort.");
    }

    @Test
    @DisplayName("Checking Debug Level Logs")
    void debug() {
        Log.debug("Designates fine-grained informational events that are most useful to debug an application.");
    }

    @Test
    @DisplayName("Checking Trace Level Logs")
    void trace() {
        Log.trace("Designates finer-grained informational events than the DEBUG.");
    }
}