import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        List<List<Integer>> answer = new Solution().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        Helper.printListofListInt(answer);
    }

    static class Solution {
        List<List<Integer>> solution = new ArrayList<>();
        HashMap<String, Boolean> atlanticFlow = new HashMap<String, Boolean>();
        HashMap<String, Boolean> pacificFlow = new HashMap<String, Boolean>();


        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            for (int x = 0; x < heights.length; x++) {
                for (int y = 0; y < heights[x].length; y++) {
                    if (getFlowAtlantic(heights, x, y) && getFlowPacific(heights, x, y)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(x);
                        temp.add(y);
                        solution.add(temp);
                    }
                }

            }
            return solution;

        }


        boolean getFlowPacific(int[][] heights, int x, int y) {
            if (heights[x][y] == -1) {
                return false;
            }
            if (pacificFlow.containsKey(getKey(x, y))) {
                return pacificFlow.get(getKey(x, y));
            } else {
                if (x == 0 || y == 0) {
                    pacificFlow.put(getKey(x, y), true);
                    return true;
                } else {
                    int temp = heights[x][y];
                    heights[x][y] = -1;
                    boolean flow = false;
                    if (heights[x - 1][y] <= temp) {
                        flow = getFlowPacific(heights, x - 1, y);
                    }
                    if (heights[x][y - 1] <= temp && !flow) {
                        flow = getFlowPacific(heights, x, y - 1);
                    }
                    if (y < heights[x].length - 1 && heights[x][y + 1] <= temp && !flow) {
                        flow = getFlowPacific(heights, x, y + 1);
                    }
                    if (x < heights.length - 1 && heights[x + 1][y] <= temp && !flow) {
                        flow = getFlowPacific(heights, x + 1, y);
                    }
                    pacificFlow.put(getKey(x, y), flow);
                    heights[x][y] = temp;
                    return flow;
                }
            }
        }

        boolean getFlowAtlantic(int[][] heights, int x, int y) {
            if (heights[x][y] == -1) {
                return false;
            }
            if (atlanticFlow.containsKey(getKey(x, y))) {
                return atlanticFlow.get(getKey(x, y));
            } else {
                if (x == heights.length - 1 || y == heights[x].length - 1) {
                    atlanticFlow.put(getKey(x, y), true);
                    return true;
                } else {
                    int temp = heights[x][y];
                    heights[x][y] = -1;
                    boolean flow = false;
                    if (heights[x + 1][y] <= temp) {
                        flow = getFlowAtlantic(heights, x + 1, y);
                    }
                    if (heights[x][y + 1] <= temp && !flow) {
                        flow = getFlowAtlantic(heights, x, y + 1);
                    }
                    if (y > 0 && heights[x][y - 1] <= temp && !flow) {
                        flow = getFlowAtlantic(heights, x, y - 1);
                    }
                    if (x > 0 && heights[x - 1][y] <= temp && !flow) {
                        flow = getFlowAtlantic(heights, x - 1, y);
                    }
                    atlanticFlow.put(getKey(x, y), flow);
                    heights[x][y] = temp;
                    return flow;
                }
            }
        }

        String getKey(int x, int y) {
            return x + "-" + y;
        }
    }
}
