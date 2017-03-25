/*----------------------------------------------------------------------------*/
/* Source File:   CUBECONTROLLER.JAVA                                         */
/* Description:   Accepts requests to the CUBE Page                           */
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

package com.csoftz.rappi.test.controller;

import com.csoftz.rappi.test.domain.LineDataStatus;
import com.csoftz.rappi.test.service.interfaces.ICubeSummationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Accepts requests to the CUBE Page.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.24/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
@Controller
@RequestMapping("/cube")
public class CubeController {
    /**
     * Logger factory.
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Cube Summation service.
     */
    private final ICubeSummationService cubeSummationService;

    /**
     * Default constructor with dependencies.
     *
     * @param cubeSummationService Injected by IoC.
     */
    public CubeController(ICubeSummationService cubeSummationService) {
        this.cubeSummationService = cubeSummationService;
    }

    /**
     * Goes to the landing page of application.
     *
     * @return Home page view.
     */
    @GetMapping("")
    public String index(Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("index started");
        }
        return "cube/index";
    }

    /**
     * Process and return information about the data supplied in the CUBE page index page.
     *
     * @return An HTML page with processing results.
     */
    @PostMapping("/process")
    public String processCubeData(String processingData, Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("processCubeData started");
            logger.info("processinData=[" + processingData + "]");
        }
        LineDataStatus lineDataStatus = cubeSummationService.validateProcessingDataFormat(processingData);
        if (lineDataStatus.isValid()) {
            cubeSummationService.execute(lineDataStatus);
        }
        model.addAttribute(lineDataStatus);
        return "cube/process-data";
    }
}
