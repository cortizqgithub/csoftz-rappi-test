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

    public CommandInfo() {
        this.commandText = "";
        this.parameters = new ArrayList<>();
    }

    public List<Integer> getParameters() {
        return parameters;
    }

    public void setParameters(List<Integer> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "CommandInfo{" +
                "commandText='" + commandText + '\'' +
                ", parameters=" + parameters +
                '}';
    }

    public String getCommandText() {
        return commandText;
    }

    public void setCommandText(String commandText) {
        this.commandText = commandText;
    }
}
