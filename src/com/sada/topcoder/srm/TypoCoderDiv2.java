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

/**
 * Single Round Match 602 Saturday, December 28th, 2013 Value: 250
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class TypoCoderDiv2 {

    public int count(int[] rating) {
        int cnt = 0;
        int currentRating = 500;
        for (int i = 0; i < rating.length; i++) {
            if (isColorChanged(currentRating, rating[i])) {
                cnt++;
            }
            currentRating = rating[i];
        }
        return cnt;
    }

    //check if the color is changes based on current and next score.
    private boolean isColorChanged(int currentScore, int nextScore) {
        if (currentScore < 1200 && nextScore >= 1200) {
            return true;
        }
        if (currentScore >= 1200 && nextScore < 1200) {
            return true;
        }

        return false;
    }
}
