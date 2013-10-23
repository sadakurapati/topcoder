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
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class KeyDungeonDiv2 {
 
  public static void main(String[] args) {
    
    int[] doorR = {41,44,41,57,58,74,84,100,58,2,43,32,82,97,44,13,35,98,96,81,43,77,18,51,27,27,39,39,45,82,59,20,28,93,6,39,64,78,28,85,17,56,3,68,4,0,36,80,41,77};
    int[] doorG = {67,15,53,36,88,29,26,57,68,99,97,27,51,70,3,49,65,75,35,92,66,0,23,96,38,86,98,31,26,75,30,2,92,78,100,99,38,26,85,74,77,15,16,48,100,88,55,93,99,54};
    int[] keys = {39,31,34}; //answer 17
    
    System.out.println(countDoors(doorR, doorG, keys));
  }
  
  public static int countDoors(int[] doorR, int[] doorG, int[] keys){
    int doors = 0;
    int length = doorR.length;
    for(int i=0; i<length; i++){
      if(canIOpenThisDoor(doorR[i], doorG[i], keys)){
        ++doors;
      }
    }
    return doors;
  }
  
  private static boolean canIOpenThisDoor(int rHoles, int gHoles, int[] keys){
    int rKeys = keys[0];
    int gKeys = keys[1];
    int wKeys = keys[2];
    
    int remRedKeys = rKeys - rHoles;
    int remGreenKeys = gKeys - gHoles;
    if(remRedKeys < 0){
      //if remaining red keys are negative, we need use white keys.
      wKeys = wKeys + remRedKeys;
    }
    if(remGreenKeys < 0){
      //if remaining green keys are negative, we need to use white keys.
      wKeys = wKeys + remGreenKeys;
    }
    
    if(wKeys < 0){
      return false;
    }
    return true;
  }
}
