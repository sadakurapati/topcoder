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
 * SRM 595 - 250
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LittleElephantAndBallsAgain {
  
  public static void main(String[] args) {
    String[] input = {null,"","RRGGBB","R","RGBRGB","RGGGBB","RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR"};
    for(String str: input){
      System.out.println(getNumber(str));
    }
  }
  
 public static int getNumber(String S)
	{
    if(null == S) return 0;
    char[] c = S.toCharArray();
    int length = c.length;
    //base case
    if(length <= 1){
      return 0;
    }
    int fc = 0;
    int lc = 1;
    for(int i=1; i < length; i++){
      //is previous element is same?
      lc = (c[i-1] == c[i])? lc+1:1;
      fc = (lc > fc)?lc:fc;
    }
    return length - fc;
	}
}
