public class MaxAreaOfIsland {
    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }

    static class Solution {
        int solution = 0;

        public int maxAreaOfIsland(int[][] grid) {
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if (grid[x][y] == 1) {

                        solution = Math.max(markIsland(grid, x, y), solution);
                    }

                }
            }
            return solution;

        }

        int markIsland(int[][] grid, int x, int y) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1) {
                grid[x][y] = -1;

                int arx = markIsland(grid, x + 1, y);
                arx += markIsland(grid, x - 1, y);
                int ary = markIsland(grid, x, y + 1);
                ary += markIsland(grid, x, y - 1);
                return arx + ary + 1;
            }
            return 0;
        }
    }
}
