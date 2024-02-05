import java.util.Arrays;

public class KokosBanana {
    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int min = 1;
            int max = maxValue(piles);

            int result = max;
            while (min <= max) {
                int mid = (min + max) / 2;
                int hour = 0;
                for (int pile : piles) {
                    hour += Math.ceilDiv(pile, mid);
                }
                if (hour <= h && hour > 0) {
                    result = Math.min(mid, result);
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return result;
        }

        int maxValue(int[] arr) {
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > temp) {
                    temp = arr[i];
                }
            }
            return temp;
        }
    }
}
