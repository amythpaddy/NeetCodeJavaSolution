public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{{'1'}, {'1'}}));
    }

    static class Solution {
        int solution = 0;

        public int numIslands(char[][] grid) {
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if (grid[x][y] == '1') {
                        solution++;
                        markIsland(grid, x, y);
                    }

                }
            }
            return solution;

        }

        void markIsland(char[][] grid, int x, int y) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1') {
                grid[x][y] = 'l';
                markIsland(grid, x - 1, y);
                markIsland(grid, x, y - 1);
                markIsland(grid, x + 1, y);
                markIsland(grid, x, y + 1);
            }
        }
    }
}
