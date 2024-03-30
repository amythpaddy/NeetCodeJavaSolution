import java.util.*;

public class Subset2 {
    public static void main(String[] args) {
        Helper.printListofListInt(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }

    static class Solution {
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> dup = new HashSet<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    getSubset(nums, i, new ArrayList<>(), "");
                }
            }
            return answer;
        }

        public void getSubset(int[] nums, int index, List<Integer> currList, String pat) {
            if (index == nums.length) {
                if (!dup.contains(pat)) {
                    dup.add(pat);
                    answer.add(currList);
                }
            } else {
                getSubset(nums, index + 1, new ArrayList<>(currList), new String(pat));
                currList.add(nums[index]);
                getSubset(nums, index + 1, new ArrayList<>(currList), new String(pat + "-" + nums[index]));
            }
        }
    }
}
