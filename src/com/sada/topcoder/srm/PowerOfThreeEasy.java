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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PowerOfThreeEasy {
    static int MAX = 1000000000;

    public String ableToGet(int x, int y) {
        Pair start = new Pair(0, 0);
        Pair target = new Pair(x, y);
        start.steps = 0;
        //do BFS
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Pair at = queue.poll();
            if (at.equals(target)) {
                return "Possible";
            }
            List<Pair> neighbors = getNeighbors(at);
            for (Pair temp : neighbors) {
                queue.offer(temp);
            }
        }
        return "Impossible";
    }

    public List<Pair> getNeighbors(Pair p) {
        List<Pair> list = new ArrayList<Pair>(2);
        int moves = (int) Math.pow(3, p.steps);
        if (p.x + moves <= MAX) {
            //move Right
            Pair right = new Pair(p.x + moves, p.y);
            right.steps = p.steps + 1;
            list.add(right);
        }
        if (p.y + moves <= MAX) {
            //move up
            Pair up = new Pair(p.x, p.y + moves);
            up.steps = p.steps + 1;
            list.add(up);
        }
        return list;
    }

    class Pair {
        int x;
        int y;
        int steps = 0;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            if (y != pair.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
