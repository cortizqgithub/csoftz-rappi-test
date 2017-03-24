/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLER.JAVA                                         */
/* Description:   Accepts requests to the HOME Page                           */
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Accepts requests to the HOME Page.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Mar.24/2017
 * @since 1.8 (JDK), Mar.24/2017
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    /**
     * Logger factory.
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Goes to the landing page of application.
     *
     * @return Home page view.
     */
    @RequestMapping("")
    public String index(Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("index started");
        }
        return "home/index";
    }
}
