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
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class RaiseThisBarn {

    public static void main(String[] args) {
        String[] input = {"cc..c.c", "c....c....c", "............", ".c.c...c..ccc.c..c.c.cc..ccc"};
        for (String str : input) {
            System.out.println("Partitions:" + calc(str));
        }
    }

    public static int calc(String str) {

        char[] c = str.toCharArray();
        int n = c.length;
        int cows = 0;
        //count cows
        for (int i = 0; i < n; i++) {
            if (c[i] == 'c') {
                ++cows;
            }
        }
        //if cows are odd, then we cant divide.
        if (cows % 2 != 0) {
            return 0;
        }
        //if no cows, then we can partition in n-1 ways.
        if (cows == 0) {
            return n - 1;
        }
        //move to half cows
        int halfCows = cows / 2;
        int counter = 0;
        int i = 0;
        for (; counter < halfCows; i++) {
            if (c[i] == 'c') {
                ++counter;
            }
        }
        int partitions = 1;
        while (c[i++] == '.') {
            ++partitions;
        }
        return partitions;
    }
}
