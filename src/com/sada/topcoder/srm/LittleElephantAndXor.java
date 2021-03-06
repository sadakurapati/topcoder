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
 * NOT COMPLETE
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LittleElephantAndXor {

    public static void main(String[] args) {
        int a = 1000000000;
        int b = 1000000000;
        int c = 500000000;
        System.out.println(getNumber(a, b, c));
    }

    public static long getNumber(int A, int B, int C) {

        long cnt = 0l;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                if ((i ^ j) > C) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
