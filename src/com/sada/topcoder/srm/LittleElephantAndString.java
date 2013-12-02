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
 * [11/20/2013] SRM 597 - 500
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LittleElephantAndString {

  public static void main(String[] args) {
    String A = "CABDEF";
    String B = "ACBDEF";
    System.out.println(getNumber(A, B));
  }

  public static int getNumber(String A, String B) {
    char[] t1 = A.toCharArray();
    char[] t2 = B.toCharArray();
    Arrays.sort(t1);
    Arrays.sort(t2);
    if (!Arrays.equals(t1, t2)) {
      return -1;
    }

    //go till it is matching
    int l1 = 0, l2 = 0;

    while (l2 < B.length() && A.charAt(l1) != B.charAt(l2)) {
      l2++;
    }
    while (l2 < B.length() && A.charAt(l1) == B.charAt(l2)) {
      l1++;
      l2++;
    }
    System.out.println(A.length() - lcs(A,B).length());
    int changes = A.length() - l1;
    return changes;
  }


public static String lcs(String a, String b){
    int aLen = a.length();
    int bLen = b.length();
    if(aLen == 0 || bLen == 0){
        return "";
    }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
        return lcs(a.substring(0,aLen-1),b.substring(0,bLen-1))
            + a.charAt(aLen-1);
    }else{
        String x = lcs(a, b.substring(0,bLen-1));
        String y = lcs(a.substring(0,aLen-1), b);
        return (x.length() > y.length()) ? x : y;
    }
}

}
