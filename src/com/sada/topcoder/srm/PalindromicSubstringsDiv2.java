/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Sada Kurapati <sadakurapati@gmail.com>
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

public class PalindromicSubstringsDiv2 {

    public int count(String[] S1, String[] S2) {
        StringBuilder S = new StringBuilder();
        for (String s : S1) {
            S.append(s);
        }

        for (String s : S2) {
            S.append(s);
        }
        int count = S.length();
        int length = S.length();
        for (int chars = 2; chars <= length; chars++) {
            for (int start = 0; start + chars <= length; start++) {
                String str = S.substring(start, start + chars);
                if (isPalindrome(str)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(String str) {
        if (str.length() < 1) {
            return false;
        }
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }
}
