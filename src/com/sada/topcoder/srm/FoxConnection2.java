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

public class FoxConnection2 {
    //Flood fill, find connected regions and calculate the ways.

    public int ways(int[] A, int[] B, int k) {
        int max = 0;
        Map<Integer, List<Integer>> map = prepareCityMap(A, B);
        for (int i = 0; i < A.length; i++) {
            int temp = getConnectedCitiesCount(A[i], map);
            if (temp > max) {
                max = temp;
            }
        }
        return max - k;
    }

    public int getConnectedCitiesCount(Integer start, Map<Integer, List<Integer>> map) {
        Set<Integer> ans = new HashSet<Integer>();
        List<Integer> list = map.get(start);
        if (null != list) {

            while (null != list) {
                ans.addAll(list);
                list = getNeighbors(list, map);
            }
        }
        return ans.size();
    }

    public List<Integer> getNeighbors(List<Integer> cities, Map<Integer, List<Integer>> map) {
        List<Integer> ans = new ArrayList<Integer>();
        for (Integer city : cities) {
            List<Integer> nh = map.get(city);
            if (null != nh) {
                ans.addAll(nh);
            }
        }

        return ans;
    }

    public Map<Integer, List<Integer>> prepareCityMap(int[] A, int[] B) {
        HashMap<Integer, List<Integer>> ans = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = ans.get(A[i]);
            if (null == list) {
                list = new ArrayList<Integer>();
                ans.put(A[i], list);
            }
            list.add(B[i]);
        }

        return ans;
    }
}
