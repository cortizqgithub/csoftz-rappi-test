/*----------------------------------------------------------------------------*/
/* Source File:   ICUBESUMMATIONSERVICE.JAVA                                  */
/* Description:   A service interface to make computations for CUBE Summation */
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
package com.csoftz.rappi.test.service.interfaces;

import com.csoftz.rappi.test.domain.LineDataStatus;

/**
 * A service interface to make computations for CUBE Summation
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Mar.24/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
public interface ICubeSummationService {
    /**
     * the first line contains an integer T, the number of test-cases. T testcases follow.
     * For each test case, the first line will contain two integers N and M separated by a single space.
     * N defines the N * N * N matrix.
     * M defines the number of operations.
     * The next M lines will contain either
     * <p>
     * 1. UPDATE x y z W
     * 2. QUERY  x1 y1 z1 x2 y2 z2
     *
     * @param processingData
     * @return An instance of LineDataStatus to indicate the status of the validation.
     */
    LineDataStatus validateProcessingDataFormat(String processingData);

    /**
     * After having validated the input format it is now time to execute to generate an output out of it.
     *
     * @param lineDataStatus The data to work on.
     */
    void execute(LineDataStatus lineDataStatus);
}
