import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> x : ans) {
            for (int i : x) {
                System.out.print(i + "--");
            }
            System.out.println();
        }
    }

    static class Solution {
        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            getCombination(candidates, target, 0, 0, new ArrayList<>());
            return answer;
        }

        void getCombination(int[] candidates, int target, int index, int currSum, List<Integer> currCombination) {
            while (index < candidates.length) {
                if (currSum + candidates[index] == target) {
                    List<Integer> temp = new ArrayList<>(currCombination);
                    temp.add(candidates[index]);
                    answer.add(temp);
                } else if (currSum + candidates[index] < target) {
                    List<Integer> temp = new ArrayList<>(currCombination);
                    temp.add(candidates[index]);
                    getCombination(candidates, target, index, currSum + candidates[index], temp);
                }
                index++;
            }
        }
    }
}

