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
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LittleElephantAndBooks {

    public static void main(String[] args) {
        int[] pages = {74, 86, 32, 13, 100, 67, 77};
        int number = 2;
        System.out.println(getNumber(pages, number));
    }

    public static int getNumber(int[] pages, int number) {
        //sorting to pick the lowest sum of pages to read
        Arrays.sort(pages);
        int sum = 0;
        //Add first number-1 books.
        for (int i = 0; i < number - 1; i++) {
            sum += pages[i];
        }
        /**
         * skip the number+1(index will be number) book as elephant Liviv need to
         * read little more than lowest. *
         */
        sum += pages[number];
        return sum;
    }
}
