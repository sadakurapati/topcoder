package com.sada.topcoder.srm;

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

/**
 * SRM 599 - 500
 * INCOMPLETE
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class BigFatInteger2 {

    public static void main(String[] args) {
        int A = 8;
        int B = 100;
        int C = 4;
        int D = 200;
        System.out.println(isDivisible(A, B, C, D));
    }

    public static String isDivisible(int A, int B, int C, int D) {

        int gc1 = gcd(A, C);
        if (gc1 == 1) {
            return "not divisible";
        }
        int gc = gcd(B, D);
        long sum1 = (long) Math.pow(A, gc);
        long sum2 = (long) Math.pow(C, gc);
        if (sum1 % sum2 == 0) {
            return "divisible";
        } else {
            return "not divisible";
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
