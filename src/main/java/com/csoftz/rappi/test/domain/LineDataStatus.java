/*----------------------------------------------------------------------------*/
/* Source File:   LINEDATASTATUS.JAVA                                         */
/* Description:   Domain to return processing data line valid.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.24/2017                                                 */
/* Last Modified: Mar.25/2017                                                 */
/* Version:       1.2                                                         */
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
 * Domain to return processing data line valid.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Mar.25/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
public class LineDataStatus {
    private boolean valid;
    private String errorDescription;
    private List<TestCaseData> testCases;
    private String outputResult;

    public LineDataStatus() {
        this.valid = false;
        this.errorDescription  = "";
        this.outputResult = "";
        this.testCases = new ArrayList<>();
    }

    public List<TestCaseData> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCaseData> testCases) {
        this.testCases = testCases;
    }

    public String getOutputResult() {
        return outputResult;
    }

    public void setOutputResult(String outputResult) {
        this.outputResult = outputResult;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "LineDataStatus{" +
                "valid=" + valid +
                ", errorDescription='" + errorDescription + '\'' +
                ", testCases=" + testCases +
                '}';
    }
}
