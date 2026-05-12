class Solution {

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check column
        for (int r = 0; r <= row; r++) {
            if (board[r][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int r = row, c = col; r >= 0 && c < n; r--, c++) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        return true;
    }


    public static void backtrack(int[][] board, int currentRow,int n,List<List<String>> solutions) {
        if (currentRow == n) {
            List<String> solution = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                String boardRow = "";

                for (int col = 0; col < n; col++) {
                    if (board[row][col] == 1) {
                        boardRow += "Q";
                    } else {
                        boardRow += ".";
                    }
                }

                solution.add(boardRow);
            }

            solutions.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, currentRow, col, n)) {
                board[currentRow][col] = 1;
                backtrack(board, currentRow + 1, n, solutions);
                board[currentRow][col] = 0; // backtrack
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> solutions = new ArrayList<>();
        backtrack(board, 0, n, solutions);
        return solutions;
    }
}