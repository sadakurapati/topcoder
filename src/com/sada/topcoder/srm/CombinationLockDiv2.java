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

import java.util.*;

public class CombinationLockDiv2 {

    public int minimumMoves(String S, String T) {
        if (S.equals(T)) {
            return 0;
        }

        Set<String> frontier = new HashSet<String>();
        HashMap<String, Integer> level = new HashMap<String, Integer>();
        int moves = 1;
        frontier.add(S);
        level.put(S, 0);
        while (!frontier.isEmpty()) {
            Set<String> next = new HashSet<String>();
            for (String parent : frontier) {
                for (String neighbor : getNeibors(parent)) {
                    if (!level.containsKey(neighbor)) {
                        level.put(neighbor, moves);
                        next.add(neighbor);
                    }
                }
            }
            if (level.containsKey(T)) {
                return level.get(T);
            }
            moves++;
            frontier = next;
        }
        return level.get(T);
    }


    public List<String> getNeibors(String str) {
        List<String> answer = new ArrayList<String>();
        int length = str.length();
        for (int chars = 1; chars <= length; chars++) {
            for (int start = 0; start + chars <= length; start++) {
                //String neighbor = str.substring(start, start + chars);
                answer.add(moveUp(str, start, chars));
                answer.add(moveDown(str, start, chars));
            }

        }
        return answer;
    }

    public String moveUp(String str, int start, int chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i >= start && i < start + chars) {
                Integer up = moveUp((int) str.charAt(i) - '0');
                sb.append(up);
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public Integer moveUp(int num) {
        if (num == 9) {
            return 0;
        } else {
            return ++num;
        }
    }

    public String moveDown(String str, int start, int chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i >= start && i < start + chars) {
                Integer down = moveDown((int) str.charAt(i) - '0');
                sb.append(down);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public Integer moveDown(int num) {
        if (num == 0) {
            return 9;
        } else {
            return --num;
        }
    }
}
