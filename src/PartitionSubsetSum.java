public class PartitionSubsetSum {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }

    static class Solution {
        int halfSum = -1;

        public boolean canPartition(int[] nums) {
            int totalSum = totalSum(nums);
            if (totalSum % 2 != 0)
                return false;
            halfSum = totalSum / 2;
            return solution(nums.length - 1, halfSum, nums);
        }

        public int totalSum(int[] nums) {
            int totalSum = 0;
            for (int num : nums) {
                totalSum += num;
            }
            return totalSum;
        }

        private boolean solution(int index, int target, int[] nums) {
            if (target == 0) {
                return true;
            } else if (index == 0) {
                return target == nums[index];
            }

            boolean notTake = false;
            notTake = solution(index--, target, nums);
            boolean take = false;
            if (nums[index] < target)
                take = solution(index--, target - nums[index], nums);
            return take || notTake;

        }
    }
}
