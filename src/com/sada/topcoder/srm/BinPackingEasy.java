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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [11/29/2013] SRM 598 - 250
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class BinPackingEasy {

    public static void main(String[] args) {
        int[] item = {130, 140, 150, 160};
        System.out.println(minBins(item));
        System.out.println(minBins1(item));
    }

    public static int minBins1(int[] item) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(item);
        for (int k = item.length - 1; k >= 0; k--) {
            int i = 0;
            for (; i < list.size(); i++) {
                if (list.get(i) + item[k] <= 300) {
                    list.set(i, list.get(i) + item[k]);
                    break;
                }
            }
            if (i == list.size()) {
                list.add(item[k]);
            }
        }

        return list.size();
    }

    public static int minBins(int[] item) {
        ArrayList<Integer> list = new ArrayList<Integer>(item.length);
        for (int it : item) {
            list.add(it);
        }
        Collections.sort(list, Collections.reverseOrder());
        int binMax = 300;
        int binCount = 0;
        while (list.size() > 0 && fillBin(list, binMax)) {
            binCount++;
        }
        return binCount;
    }

    public static boolean fillBin(List<Integer> items, int binSize) {
        int itemCount = 0;
        int i = 0;
        while (i < items.size() && itemCount < 2 && binSize > 0) {
            if (items.get(i) <= binSize) {
                //consume this bin
                binSize -= items.get(i);
                items.remove(i);
                ++itemCount;
            } else {
                ++i;
            }
        }
        if (itemCount > 0) {
            return true;
        } else {
            return false;
        }
    }
}
