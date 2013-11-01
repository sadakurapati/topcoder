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
import java.util.HashSet;

/**
 * SRM 595 - 500
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LittleElephantAndIntervalsDiv2 {

  public static void main(String[] args) {
    int M = 3;
    int[] L = {1, 1, 2};
    int[] R = {3, 1, 2};
    System.out.println(getNumber(M, L, R));
  }

  public static int getNumber(int M, int[] L, int[] R) {
    int[] colorChanges = new int[M];
    // false - white, true - black
    boolean[] currentState = new boolean[M];
    Arrays.fill(colorChanges, 0);
    int k = 0;
    int length = L.length;
    for (int i = 0; i < length; i++) {
      //what color to choost?
      int whiteBallsCount = getWhiteColoredBallsCount(currentState, L[i]-1, R[i]-1);
      //choose least used color to get maximum
      boolean option = false;
      int blackBallsCount = R[i] - L[i] +1 - whiteBallsCount;
      if(blackBallsCount < whiteBallsCount){
        option = true;
      }
      for (k = L[i]-1; k < R[i]; k++) {
        if(currentState[i] != option){
          ++colorChanges[i];
          currentState[i] = option;
        }
      }
    }
    int answer = 0;
    for(int i = 0; i< M; i++){
      answer+=colorChanges[i];
    }
    return answer;
  }

  public static int getWhiteColoredBallsCount(boolean[] currentState, int start, int end) {
    int whiteBalls = 0;
    for (int i = start; i <= end; i++) {
      if (!currentState[i]) {
        ++whiteBalls;
      }
    }
    return whiteBalls;
  }
}
