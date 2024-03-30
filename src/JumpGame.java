public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    static class Solution {
        boolean answer = false;
        boolean[] memo;

        public boolean canJump(int[] nums) {
            memo = new boolean[nums.length];
//            System.out.println(memo[2]);
            checkCanJump(nums, 0, nums[0]);
            return answer;
        }

        void checkCanJump(int[] nums, int start, int limit) {
            if (!memo[start]) {
                memo[start] = true;
                if (!answer) {
                    if (start == nums.length - 1) {
                        answer = true;
                        return;
                    }
                    for (int i = start + 1; i < start + limit + 1 && !answer; i++) {
                        checkCanJump(nums, i, nums[i]);
                    }
                }
            }
        }
    }
}
