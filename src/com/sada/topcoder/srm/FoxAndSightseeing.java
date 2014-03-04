/*
 * The MIT License
 *
 * Copyright 2013 Sada Kurapati <sadakurapati@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sada.topcoder.srm;

/**
 * [11/01/2013] SRM 596 - 250
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class FoxAndSightseeing {

    public static void main(String[] args) {
        //int[] L = {1, 4, -1, 3}; //4
        //int[] L = {-2, 4, 3}; //5
        //int[] L = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //9
        //int[] L = {74,84,92,23,5,-70,-47,-59,24,-86,-39,99,85,-42,54,100,47,-3,42,38}; //836
        int[] L = {2, -3, 5, 7, -11, -13, 17, -19, 23, 29, -31, -37, -41, 43, -47, -53, -59, 61, -67, 71}; //535

        System.out.println(getMin(L));
    }

    public static int getMin(int[] position) {
        int length = position.length;
        //Base case.
        if (length == 3) {
            return Math.abs(position[0] - position[2]);
        }
        //finding max distance
        int currentMaxAt = -1;
        int currentMax = Integer.MIN_VALUE;
        int sum = 0;
        sum += Math.abs(position[0] - position[1]);
        for (int i = 1; i < length - 1; i++) {
            int d1 = Math.abs(position[i - 1] - position[i]); //city 1 to 2
            int d2 = Math.abs(position[i] - position[i + 1]); //city 2 to 3
            int d3 = Math.abs(position[i - 1] - position[i + 1]);//city 1 to 3 skipping 2
            int skipDistance = d1 + d2 - d3;
            if (skipDistance > currentMax) {
                currentMax = skipDistance;
                currentMaxAt = i;
            }
            sum += Math.abs(position[i] - position[i + 1]);
        }
        //remove skipping city distances.
        int d1 = Math.abs(position[currentMaxAt - 1] - position[currentMaxAt]);
        int d2 = Math.abs(position[currentMaxAt] - position[currentMaxAt + 1]);
        int d3 = Math.abs(position[currentMaxAt - 1] - position[currentMaxAt + 1]);
        sum += d3 - d1 - d2;
        return sum;
    }

}
