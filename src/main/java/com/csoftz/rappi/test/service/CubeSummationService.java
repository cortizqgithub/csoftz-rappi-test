/*----------------------------------------------------------------------------*/
/* Source File:   CUBESUMMATIONSERVICE.JAVA                                   */
/* Description:   A service to make computations for CUBE Summation           */
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

package com.csoftz.rappi.test.service;

import com.csoftz.rappi.test.domain.LineDataStatus;
import com.csoftz.rappi.test.service.interfaces.ICubeSummationService;
import org.springframework.stereotype.Service;

/**
 * A service to make computations for CUBE Summation
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Mar.24/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
@Service
public class CubeSummationService implements ICubeSummationService {
    /**
     * See documentation in interface class.
     *
     * @param processingData Data to Validate
     * @return The data to process and its status.
     */
    @Override
    public LineDataStatus validateProcessingDataFormat(String processingData) {
        LineDataStatus lineStatus = new LineDataStatus();
        String[] lines = processingData.split("\\r?\\n");
        for (String line : lines) {
            String[] items = line.split(" ");
            System.out.println("Items length=" + items.length);
        }
        return lineStatus;
    }

    /**
     * See documentation in interface class.
     * @param lineDataStatus The data to work on.
     */
    @Override
    public void execute(LineDataStatus lineDataStatus) {

    }
}
