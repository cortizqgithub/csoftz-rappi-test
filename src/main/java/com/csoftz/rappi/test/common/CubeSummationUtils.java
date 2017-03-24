/*----------------------------------------------------------------------------*/
/* Source File:   CUBESUMMATIONUTILS.JAVA                                     */
/* Description:   Utilities for Cube Summation                                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.23/2017                                                 */
/* Last Modified: Mar.24/2017                                                 */
/* Version:       1.3                                                         */
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
 * @version 1.3, Mar.24/2017
 * @since 1.8 (JDK), Mar.23/2017
 */
public class CubeSummationUtils {
    private int[][][] data; // Information to work on.
    private int N; // Array dimension.

    /**
     * Creates an array with N Dimension and sets all of its cells to zero.
     *
     * @param N Holds the 3DArray dimension.
     */
    public void createArray(int N) {
        this.N = N;
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
     * Write to cell in position (x,y,z) the value given by value
     *
     * @param x     Position X
     * @param y     Position Y
     * @param z     Position Z
     * @param value Data to set.
     */
    public void updateCell(int x, int y, int z, int value) {
        data[x][y][z] = value;
    }

    /**
     * Return the sum from point (x1, y1, z1) through (x2, y2, z2).
     * Note 1<=x1<=x2<=N (N is the dimension of array).
     *
     * @param x1 Start point in X axis
     * @param y1 Start point in Y axis
     * @param z1 Start point in Z axis
     * @param x2 End point in X axis
     * @param y2 End point in Y axis
     * @param z2 End point in Z axis
     * @return Sum of cells involved.
     */
    public int summation(int x1, int y1, int z1, int x2, int y2, int z2) {
        return 0;
    }
}
