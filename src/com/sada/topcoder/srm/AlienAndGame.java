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

//TODO - INCOMPLETE
public class AlienAndGame {

    public int getNumber(String[] board) {
        return 0;
    }

    private int getArea(String[] board) {
        int ans = 1;

        int[] inInts = convertInput(board);
        int temp = inInts[0];
        for (int i = 0; i < inInts.length; i++) {
            temp = temp & inInts[i];
        }
        //TODO - complete code :)
        return ans;
    }

    private void shift(String[] board, int index) {
        String oldRow = board[index];
        StringBuilder sb = new StringBuilder(oldRow);
        for (int i = 0; i < oldRow.length(); i++) {
            if (oldRow.charAt(i) == 'W') {
                sb.setCharAt(i, 'B');
            } else {
                sb.setCharAt(i, 'W');
            }
        }
        board[index] = sb.toString();
    }

    private int[] convertInput(String[] board) {
        int[] result = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            result[i] = convertToInt(board[i]);
        }
        return result;
    }

    private int convertToInt(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'W') {
                setBit(ans, i + 1);
            }
        }

        return ans;
    }

    private int setBit(int number, int position) {
        return (1 << position | number);
    }
}
