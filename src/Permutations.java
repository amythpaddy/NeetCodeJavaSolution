import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> sol = new Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> arr : sol) {
            for (int i : arr) {
                System.out.print(i + "--");
            }
            System.out.println();
        }
    }

    static class Solution {
        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> container = new ArrayList<>();
            for (int i : nums) {
                container.add(i);
            }
            geneator(new ArrayList<>(container), new ArrayList<>(), container.size());
            return answer;
        }

        void geneator(List<Integer> nums, List<Integer> currList, int size) {
            List<Integer> orgList = new ArrayList<>(nums);
            for (int i = 0; i < orgList.size(); i++) {
                List<Integer> tempList = new ArrayList<>(currList);

                tempList.add(nums.get(i));
                if (tempList.size() == size) {
                    answer.add(tempList);
                }
                orgList.remove(i);
                geneator(orgList, tempList, size);
                orgList = new ArrayList<>(nums);


            }

        }
    }
}
