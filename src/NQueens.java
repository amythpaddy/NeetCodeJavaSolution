import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Helper.printListofListStr(new Solution().solveNQueens(4));
    }

    static class Solution {
        List<List<String>> solution = new ArrayList<>();
        String def = "";

        public List<List<String>> solveNQueens(int n) {
            int board[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                def = def + ".";
            }
            for (int i = 0; i < n; i++) {
                getSolution(board, 0, 0, n, new ArrayList<>());
            }
            return solution;
        }

        private void getSolution(int[][] board, int x, int y, int n, List<String> currentString) {
            if (board[x][y] == 1) {
                return;
            } else if (x == n - 1 && y == 0) {
                
            }
        }
    }
}
