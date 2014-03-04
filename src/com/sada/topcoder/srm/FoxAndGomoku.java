package com.sada.topcoder.srm;

public class FoxAndGomoku {
    public String win(String[] board) {

        //check the rows
        for (int i = 0; i < board.length; i++) {
            if (isWin(board[i])) {
                return "found";
            }
        }
        //check columns
        for (int i = 0; i < board[0].length(); i++) {
            String str = getColumnString(board, i);
            if (isWin(str)) {
                return "found";
            }
        }

        return "not found";
    }

    public String getColumnString(String[] board, int column) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append(board[i].charAt(column));
        }
        return sb.toString();
    }

    public boolean isWin(String row) {
        int cnt = 0;
        char last = ' ';
        for (int i = 0; i < row.length(); i++) {
            if (cnt >= 5) {
                return true;
            }
            if (last == row.charAt(i) && last == 'o') {
                cnt++;
            } else {
                cnt = 0;
            }
            last = row.charAt(i);
        }

        return false;
    }
}
