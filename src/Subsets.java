import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().subsets(new int[]{1, 2, 3});
        for (List<Integer> i : ans) {
            for (int num : i) {
                System.out.print(num + "--");
            }
            System.out.println();
        }

    }

    static class Solution {
        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> tempStore = new ArrayList<>();
            answer.add(tempStore);
            getSubsets(new ArrayList<>(tempStore), nums, 0);
            return answer;
        }

        void getSubsets(List<Integer> tempStore, int[] arr, int index) {
            if (index < arr.length) {

                int value = arr[index++];
                getSubsets(new ArrayList<>(tempStore), arr, index);
                tempStore.add(value);

                answer.add(new ArrayList<>(tempStore));
                getSubsets(new ArrayList<>(tempStore), arr, index);
            }
        }
    }
}
