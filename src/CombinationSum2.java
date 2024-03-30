import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        Helper.printListofListInt(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    static class Solution {
        Set<List<Integer>> solution = new HashSet<>();
        int prev = -1;
        int[] candidates;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            this.candidates = candidates;
            Arrays.sort(candidates);

            getSolution(new ArrayList<>(), 0, target);

            return new ArrayList<>(solution);
        }

        void getSolution(List<Integer> currList, int pos, int target) {
            int prev = -1;
            if (target < 0)
                return;
            else if (target == 0) {
                solution.add(currList);
            } else {
                for (int i = pos; i < candidates.length; i++) {
                    if (candidates[i] != prev) {
                        currList.addLast(candidates[i]);
                        getSolution(new ArrayList<>(currList), i + 1, target - candidates[i]);
                        currList.removeLast();
                        prev = candidates[i];
                    }
                }
            }
        }
    }
}
