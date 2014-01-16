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
 * Single Round Match 603 Monday, January 6th, 2014 Value: 250
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class MiddleCode {

  public String encode(String s) {
    StringBuilder from = new StringBuilder(s);
    StringBuilder to = new StringBuilder();
    while (from.length() > 0) {
      int mid = from.length() / 2;
      //if length is even, compare and take the small char
      if (from.length() % 2 == 0) {
        char c1 = from.charAt(mid - 1);
        char c2 = from.charAt(mid);
        if (c1 < c2) {
          mid = mid - 1;
        }
      }
      to.append(from.charAt(mid));
      from.deleteCharAt(mid);
    }
    return to.toString();
  }
}
