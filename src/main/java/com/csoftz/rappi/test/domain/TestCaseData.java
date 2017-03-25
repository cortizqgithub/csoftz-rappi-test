/*----------------------------------------------------------------------------*/
/* Source File:   TESTCASEDATA.JAVA                                           */
/* Description:   Domain to contain the commands and dimension of test case.  */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.24/2017                                                 */
/* Last Modified: Mar.24/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.24/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.rappi.test.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain to contain the commands and dimension of test case.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Mar.24/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
public class TestCaseData {
    private int arrayDimension;
    private List<String> commands;

    public TestCaseData() {
        this.arrayDimension = 0;
        this.commands = new ArrayList<>();
    }

    public int getArrayDimension() {
        return arrayDimension;
    }

    public void setArrayDimension(int arrayDimension) {
        this.arrayDimension = arrayDimension;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "TestCaseData{" +
                "arrayDimension=" + arrayDimension +
                ", commands=" + commands +
                '}';
    }
}
