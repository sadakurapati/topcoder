/*
 * The MIT License
 *
 * Copyright 2014 Sada Kurapati <sadakurapati@gmail.com>.
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
 * Single Round Match 603 Monday, January 6th, 2014 Value: 500
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class SplitIntoPairs {

    public int makepairs(int[] A, int X) {
        Arrays.sort(A);
        boolean[] state = new boolean[100];
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (!state[i]) {
                int pick = A[i];
                state[i] = true;
                int pair = getBestPair(A, X, pick, state);
                if (pair < 0) {
                    state[i] = false; //put this back in pool
                    continue;
                }
                state[pair] = true;
                answer++;
            }
        }
        return answer;
    }

    //pick smaller available pair
    public int getBestPair(int[] A, int X, int pick, boolean[] state) {
        int ans = -1;
        for (int i = 0; i < A.length; i++) {
            if (!state[i]) {
                long value = (long) pick * A[i];
                if (value >= X) {
                    return i;
                }
            }
        }

        return ans;
    }
}
