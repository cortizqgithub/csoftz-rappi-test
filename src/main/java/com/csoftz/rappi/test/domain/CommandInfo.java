/*----------------------------------------------------------------------------*/
/* Source File:   COMMANDINFO.JAVA                                            */
/* Description:   Domain to hold one line statment for execution.             */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.25/2017                                                 */
/* Last Modified: Mar.25/2017                                                 */
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
 * Domain to hold one line statment for execution.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.25/2017
 * @since 1.8 (JDK), Mar.25/2017
 */
public class CommandInfo {
    private String commandText;
    private List<Integer> parameters;

    /**
     * Default constructor
     */
    public CommandInfo() {
        this.commandText = "";
        this.parameters = new ArrayList<>();
    }

    /**
     * Getter for parameters
     * @return List of parameters
     */
    public List<Integer> getParameters() {
        return parameters;
    }

    /**
     * Setter for parameters
     * @param parameters Data to set
     */
    public void setParameters(List<Integer> parameters) {
        this.parameters = parameters;
    }

    /**
     * String interpretation.
     * @return Object field printing.
     */
    @Override
    public String toString() {
        return "CommandInfo{" +
                "commandText='" + commandText + '\'' +
                ", parameters=" + parameters +
                '}';
    }

    /**
     * Getter for commandText
     * @return Text of command
     */
    public String getCommandText() {
        return commandText;
    }

    /**
     * Setter for commandText
     * @param commandText Data to set
     */
    public void setCommandText(String commandText) {
        this.commandText = commandText;
    }
}
