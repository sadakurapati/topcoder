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
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class HexagonalBoard {

    public static void main(String[] args) {
        String[] board = {"XX-XX--"
                , "-XX-XXX"
                , "X-XX--X"
                , "X--X-X-"
                , "XX-X-XX"
                , "-X-XX-X"
                , "-XX-XX-"};
        HexagonalBoard o = new HexagonalBoard();
        System.out.println(o.minColors(board));
    }

    public int minColors(String[] board) {
        int maxColors = 0;
        char[][] charBoard = buildCharArray(board);
        for (int i = 0; i < board[0].length(); i++) {
            for (int j = 0; j < board.length; j++) {
                maxColors = colorThisCell(charBoard, i, j, maxColors);
            }
        }
        return maxColors;
    }

    public char[][] buildCharArray(String[] board) {
        char[][] charBoard = new char[board[0].length()][board.length];
        for (int i = 0; i < board[0].length(); i++) {
            for (int j = 0; j < board.length; j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }
        return charBoard;
    }

    public int colorThisCell(char[][] charBoard, int row, int col, int maxColors) {
        if (charBoard[row][col] == 'X') {
            //check to see if we use the existing colors.
            int i = 1;
            for (; i <= maxColors; i++) {
                //can we use color i?
                HashSet<Integer> usedColors = new HashSet<Integer>();
                //left
                if (col > 0 && charBoard[row][col] != '-' && isValidColor(charBoard[row][col - 1])) {
                    usedColors.add(Integer.valueOf(charBoard[row][col - 1] - '0'));
                }
                //right
                if (col < charBoard[0].length - 1 && charBoard[row][col] != '-' && isValidColor(charBoard[row][col + 1])) {
                    usedColors.add(Integer.valueOf(charBoard[row][col + 1] - '0'));
                }
                //top
                if (row > 0 && charBoard[row][col] != '-' && isValidColor(charBoard[row - 1][col])) {
                    usedColors.add(Integer.valueOf(charBoard[row - 1][col] - '0'));
                }
                //bottom
                if (row < charBoard.length - 1 && charBoard[row][col] != '-' && isValidColor(charBoard[row + 1][col])) {
                    usedColors.add(Integer.valueOf(charBoard[row + 1][col] - '0'));
                }

                if (!usedColors.contains(i)) {
                    //use color i and break
                    charBoard[row][col] = Character.forDigit(i, 10);
                    break;
                }
            }
            if (i > maxColors) {
                ++maxColors;
                charBoard[row][col] = Character.forDigit(i, 10);
            }
        }
        return maxColors;
    }

    public boolean isValidColor(char c) {
        if (c != '-' && c != 'X') {
            return true;
        } else {
            return false;
        }
    }
}
