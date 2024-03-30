public class ProductOfArray {
    public static void main(String[] args) {
        int[] ans = new Solution().productExceptSelf(new int[]{0});
        for (int num : ans) {
            System.out.println(num);
        }
    }

    static class Solution {
        int zeroCount = 0;
        int prod = 1;
        int[] prodArr;

        public int[] productExceptSelf(int[] nums) {
            prodArr = new int[nums.length];
            for (int num : nums) {
                if (num == 0) {
                    zeroCount++;
                } else {
                    prod *= num;
                }
            }
            if (zeroCount >= 2 || zeroCount == nums.length)
                return prodArr;
            else {
                for (int i = 0; i < prodArr.length; i++) {
                    if (zeroCount == 0) {
                        prodArr[i] = prod / nums[i];
                    } else {
                        if (nums[i] == 0) {
                            prodArr[i] = prod;
                        }
                    }
                }
            }
            return prodArr;
        }
    }
}
