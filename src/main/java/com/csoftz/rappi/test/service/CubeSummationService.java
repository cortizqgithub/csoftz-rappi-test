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

import com.csoftz.rappi.test.domain.CommandInfo;
import com.csoftz.rappi.test.domain.LineDataStatus;
import com.csoftz.rappi.test.domain.TestCaseData;
import com.csoftz.rappi.test.service.interfaces.ICubeSummationService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        int numTestCases = 0;
        int numTestCasesScanned = 0;
        int arrayDimension = 0;
        int numExpectedCommands = 0;
        boolean validNumber;
        boolean dimensionLinePresent = false;
        boolean onScannigTestCase = false;
        TestCaseData testCaseData = null;
        String commandText;

        // Let's assume that input format is valid.
        lineStatus.setValid(true);
        if (processingData.equals("")) {
            lineStatus.setValid(false);
            lineStatus.setErrorDescription("No data supplied. Process aborted.");
        } else {
            String[] lines = processingData.split("\\r?\\n");
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].trim().equals("")) {
                    lineStatus.setValid(false);
                    lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. An empty line was found.");
                    break;
                }

                String[] items = lines[i].split(" ");
                if (i == 0) {
                    if (items.length != 1) {
                        lineStatus.setValid(false);
                        lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. No test cases number supplied");
                        break;
                    } else {
                        validNumber = true;
                        try {
                            numTestCases = Integer.parseInt(items[0]);
                        } catch (NumberFormatException e) {
                            validNumber = false;
                        }
                        if (!validNumber) {
                            lineStatus.setValid(false);
                            lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. No test cases number supplied");
                            break;
                        }
                        testCaseData = new TestCaseData();
                    }
                } else {
                    int len = items.length;
                    if (len != 2 && len != 5 && len != 7) {
                        lineStatus.setValid(false);
                        lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Line not recognized.");
                        break;
                    } else {
                        // Scan lines with two numbers. Dimension and expected commands.
                        if (len == 2) {
                            if (onScannigTestCase) {
                                numTestCasesScanned++;
                                lineStatus.getTestCases().add(testCaseData);
                                int numAddedCommands = testCaseData.getCommands().size();
                                if (numAddedCommands != numExpectedCommands) {
                                    lineStatus.setValid(false);
                                    lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Unxpected number of commands.");
                                    break;
                                }
                                testCaseData = new TestCaseData();
                            }

                            validNumber = true;
                            try {
                                arrayDimension = Integer.parseInt(items[0]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Array dimension not properly set");
                                break;
                            }
                            try {
                                numExpectedCommands = Integer.parseInt(items[1]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Number of operations not properly set");
                                break;
                            }
                            testCaseData.setArrayDimension(arrayDimension);
                            dimensionLinePresent = true;
                            onScannigTestCase = true;
                        }

                        // Scan lines that contains UPDATE or QUERY commands
                        if (len == 5) {
                            String info = items[0].trim();
                            if (!info.toUpperCase().equals("UPDATE")) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Operation must start with UPDATE");
                                break;
                            }
                            commandText = info;
                            int x1, y1, z1, w;

                            x1 = y1 = z1 = w = 0;
                            validNumber = true;
                            try {
                                x1 = Integer.parseInt(items[1]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE x1 parameter not properly set");
                                break;
                            }
                            try {
                                y1 = Integer.parseInt(items[2]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE y1 parameter not properly set");
                                break;
                            }
                            try {
                                z1 = Integer.parseInt(items[3]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE z1 parameter not properly set");
                                break;
                            }
                            try {
                                w = Integer.parseInt(items[4]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE w parameter not properly set");
                                break;
                            }

                            // At this point command line is correct. But it may be not in the expected position.
                            if (!dimensionLinePresent) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Expected Dimension and opertations quantity but UPDATE or QUERY found.");
                                break;
                            }

                            CommandInfo commandInfo = new CommandInfo();
                            commandInfo.setCommandText(commandText);
                            List<Integer> params = commandInfo.getParameters();
                            params.add(x1);
                            params.add(y1);
                            params.add(z1);
                            params.add(w);
                            testCaseData.getCommands().add(commandInfo);
                        }
                        if (len == 7) {
                            String info = items[0].trim();
                            if (!info.toUpperCase().equals("QUERY")) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Operation must start with QUERY");
                                break;
                            }

                            commandText = info;
                            int x1, y1, z1;
                            int x2, y2, z2;

                            x1 = y1 = z1 = 0;
                            x2 = y2 = z2 = 0;
                            validNumber = true;
                            try {
                                x1 = Integer.parseInt(items[1]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE x1 parameter not properly set");
                                break;
                            }
                            try {
                                y1 = Integer.parseInt(items[2]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE y1 parameter not properly set");
                                break;
                            }
                            try {
                                z1 = Integer.parseInt(items[3]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE z1 parameter not properly set");
                                break;
                            }
                            validNumber = true;
                            try {
                                x2 = Integer.parseInt(items[4]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE x2 parameter not properly set");
                                break;
                            }
                            try {
                                y2 = Integer.parseInt(items[5]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE y2 parameter not properly set");
                                break;
                            }
                            try {
                                z2 = Integer.parseInt(items[6]);
                            } catch (NumberFormatException e) {
                                validNumber = false;
                            }
                            if (!validNumber) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. UPDATE z2 parameter not properly set");
                                break;
                            }

                            // At this point command line is correct. But it may be not in the expected position.
                            if (!dimensionLinePresent) {
                                lineStatus.setValid(false);
                                lineStatus.setErrorDescription("Line " + (i + 1) + ": Invalid format. Expected Dimension and opertations quantity but UPDATE or QUERY found.");
                                break;
                            }

                            CommandInfo commandInfo = new CommandInfo();
                            commandInfo.setCommandText(commandText);
                            List<Integer> params = commandInfo.getParameters();
                            params.add(x1);
                            params.add(y1);
                            params.add(z1);
                            params.add(x2);
                            params.add(y2);
                            params.add(z2);
                            testCaseData.getCommands().add(commandInfo);
                        }
                    }
                }
            }
            numTestCasesScanned++;
            int numAddedCommands = testCaseData.getCommands().size();
            if (numAddedCommands != numExpectedCommands) {
                lineStatus.setValid(false);
                lineStatus.setErrorDescription("Invalid format. Unxpected number of commands.");
            }
        }
        lineStatus.getTestCases().add(testCaseData);

        // Check to see if we have all expected test cases.
        if (lineStatus.isValid()) {
            if (numTestCases != numTestCasesScanned) {
                lineStatus.setValid(false);
                lineStatus.setErrorDescription("Invalid format. Expected Test Cases not present.");
            }
        }
        return lineStatus;
    }

    /**
     * See documentation in interface class.
     *
     * @param lineDataStatus The data to work on.
     */
    @Override
    public void execute(LineDataStatus lineDataStatus) {
        List<TestCaseData> testCases = lineDataStatus.getTestCases();
        for (TestCaseData t : testCases) {


        }

    }
}
