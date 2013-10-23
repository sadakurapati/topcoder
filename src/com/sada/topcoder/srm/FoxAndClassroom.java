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

import java.util.HashSet;

/**
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class FoxAndClassroom {

  public static void main(String[] args) {
    HashSet<Pair> input = new HashSet<Pair>();
    input.add(new Pair(2, 3)); //Possible
    input.add(new Pair(2, 2)); //Impossible
    input.add(new Pair(4, 6)); //Impossible
    input.add(new Pair(3, 6)); //Impossible
    input.add(new Pair(2, 3)); //Impossible
    input.add(new Pair(5, 7)); //Possible
    input.add(new Pair(10, 10)); //Impossible

    for (Pair p : input) {
      System.out.printf("(%d,%d) = %s \n", p.i, p.j, ableTo(p.i, p.j));
    }
  }

  public static String ableTo(int n, int m) {
    HashSet<Pair> visited = new HashSet<Pair>();
    int i = 0, j = 0; //starting indexes
    Pair p = new Pair(i, j);
    while (!visited.contains(p)) {
      visited.add(p); // add visited pair
      i = (i + 1) % n;
      j = (j + 1) % m;
      p = new Pair(i, j);
    }
    // check if all of the chairs are visited.
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        p = new Pair(i, j);
        if (!visited.contains(p)) {
          return "Impossible";
        }
      }
    }

    return "Possible";
  }

  static class Pair {

    int i, j;

    public Pair(int a, int b) {
      i = a;
      j = b;
    }

    @Override
    public int hashCode() {
      int hash = new Integer(i).hashCode();
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Pair other = (Pair) obj;
      if (this.i != other.i) {
        return false;
      }
      if (this.j != other.j) {
        return false;
      }
      return true;
    }
  }
}
