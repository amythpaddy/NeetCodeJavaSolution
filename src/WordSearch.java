import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    static class Solution {

        public boolean exist(char[][] board, String word) {
            boolean found = false;
            for (int x = 0; x < board.length && !found; x++) {
                for (int y = 0; y < board[x].length && !found; y++) {
                    found = trace(board, word, x, y, 0);
                }
            }
            return found;
        }

        public boolean trace(char[][] board, String word, int x, int y, int match) {

            if (y < 0 || x < 0 || x >= board.length || y >= board[x].length || word.charAt(match) != board[x][y])
                return false;
            char temp = board[x][y];
            if (word.charAt(match) == board[x][y]) {
                board[x][y] = '*';
                if (match + 1 == word.length()) {
                    return true;
                }
                if (trace(board, word, x + 1, y, match + 1) ||
                        trace(board, word, x, y + 1, match + 1) ||
                        trace(board, word, x - 1, y, match + 1) ||
                        trace(board, word, x, y - 1, match + 1))
                    return true;
            }
            board[x][y] = temp;
            return false;
        }
    }
}
