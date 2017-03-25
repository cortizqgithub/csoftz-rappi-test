/*----------------------------------------------------------------------------*/
/* Source File:   CUBESUMMATIONUTILS.JAVA                                     */
/* Description:   Utilities for Cube Summation                                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.23/2017                                                 */
/* Last Modified: Mar.25/2017                                                 */
/* Version:       1.4                                                         */
/* Copyright (c), 2017 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.23/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.rappi.test.common;

/**
 * Utilities for Cube Summation.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.4, Mar.25/2017
 * @since 1.8 (JDK), Mar.23/2017
 */
public class CubeSummationUtils {
    private int[][][] data; // Information to work on.

    /**
     * Creates an array with N Dimension and sets all of its cells to zero.
     *
     * @param N Holds the 3DArray dimension.
     */
    public void createArray(int N) {
        data = new int[N][N][N];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length; k++) {
                    data[i][j][k] = 0;
                }
            }
        }
    }

    /**
     * Print to STDOUT the 3D array contents.
     */
    public void print3DArray() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length; k++) {
                    System.out.println("data[" + i + "][" + j + "][" + k + "] = " + data[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------");
        }
    }

    /**
     * Write to cell in position (x,y,z) the value given by value.
     * Values must be in the range 1 <= N, thus in java as it is zero-based reference
     * must be value minus 1.
     *
     * @param x     Position X
     * @param y     Position Y
     * @param z     Position Z
     * @param value Data to set.
     */
    public void updateCell(int x, int y, int z, int value) {
        data[x - 1][y - 1][z - 1] = value;
    }

    /**
     * Return the sum from point (x1, y1, z1) through (x2, y2, z2).
     * Note 1 <= x1 <= x2 <= N (N is the dimension of array).
     * <p>
     * Values must be in the range 1 <= N, thus in java as it is zero-based reference
     * must be value minus 1.
     *
     * @param x1 Start point in X axis
     * @param y1 Start point in Y axis
     * @param z1 Start point in Z axis
     * @param x2 End point in X axis
     * @param y2 End point in Y axis
     * @param z2 End point in Z axis
     * @return Sum of cells involved.
     */
    public int summation(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        int x1Data, y1Data, z1Data;
        int x2Data, y2Data, z2Data;
        int rslt = 0;

        x1Data = x1;
        y1Data = y1;
        z1Data = z1;
        x2Data = x2;
        y2Data = y2;
        z2Data = z2;
        while (x1Data <= x2Data && y1Data <= y2Data && z1Data <= z2Data) {
            rslt += data[x1Data - 1][y1Data - 1][z1Data - 1];
            x1Data++;
            y1Data++;
            z1Data++;
        }
        return rslt;
    }
}
