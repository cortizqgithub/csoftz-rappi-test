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
    private List<CommandInfo> commands;

    /**
     * Default constructor
     */
    public TestCaseData() {
        this.arrayDimension = 0;
        this.commands = new ArrayList<>();
    }

    /**
     * Getter for Size of cube dimension
     * @return Value to get
     */
    public int getArrayDimension() {
        return arrayDimension;
    }

    /**
     * Setter for Size of cube dimension
     * @param arrayDimension Value to set
     */
    public void setArrayDimension(int arrayDimension) {
        this.arrayDimension = arrayDimension;
    }

    /**
     * Getter for Commands to process
     * @return Commands to get
     */
    public List<CommandInfo> getCommands() {
        return commands;
    }

    /**
     * Setter for Commands to process
     * @param commands
     */
    public void setCommands(List<CommandInfo> commands) {
        this.commands = commands;
    }

    /**
     * String interpretation.
     * @return Object field printing.
     */
    @Override
    public String toString() {
        return "TestCaseData{" +
                "arrayDimension=" + arrayDimension +
                ", commands=" + commands +
                '}';
    }
}
