import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        new Solution().subsets(new int[]{1, 2, 3});
    }

    static class Solution {
        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> tempStore = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    tempStore.add(nums[j]);
                }
                answer.add(tempStore);
            }
            return answer;
        }
    }
}
