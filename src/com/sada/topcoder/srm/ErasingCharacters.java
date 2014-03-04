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
 * [11/29/2013] SRM 598 - 500
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class ErasingCharacters {
    public static void main(String[] args) {
        String s = "aabcddce";
        System.out.println(simulate(s));
        System.out.println(simulate1(s));
    }

    public static String simulate(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0) {
            //find the repeating character
            int n = sb.length();
            int at = -1;
            for (int i = 1; i < n; i++) {
                if (sb.charAt(i - 1) == sb.charAt(i)) {
                    at = i - 1;
                    break;
                }
            }
            if (at == -1) {
                return sb.toString();
            } else {
                //remove both chars.
                sb.deleteCharAt(at);
                sb.deleteCharAt(at);
            }
        }
        return sb.toString();
    }

    public static String simulate1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i + 1 < sb.length()) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                //reset i;
                i = 0;
            } else {
                ++i;
            }
        }
        return sb.toString();
    }
}
