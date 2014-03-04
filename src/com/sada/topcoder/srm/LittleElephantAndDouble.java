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

import java.util.Arrays;

/**
 * FAILED - getAnswer1
 * [11/20/2013] SRM 597 - 250
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LittleElephantAndDouble {

    public static void main(String[] args) {
        int[] A = {1, 2, 3}; //NO
        //int[] A = {148, 298, 1184}; //NO
        //int[] A = {4, 8, 2, 1, 16};
        //int[] A = {94, 752, 94, 376, 1504};
        System.out.println(getAnswer(A)); //this is wrong one
        System.out.println(getAnswer1(A));
    }

    public static String getAnswer(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int max = A[len - 1];
        for (int i = 0; i < len - 1; i++) {
            int remainder = max % A[i];
            if (remainder != 0 && remainder != 1) {
                return "NO";
            }
        }
        return "YES";
    }

    public static String getAnswer1(int[] A) {
        int len = A.length;
        if (len == 1) {
            return "YES";
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] % 2 == 0) {
                A[i] = A[i] / 2;
            }
        }
        System.out.println(Arrays.toString(A));
        //now array should contain all same elements then return yes, else no
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] != A[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
