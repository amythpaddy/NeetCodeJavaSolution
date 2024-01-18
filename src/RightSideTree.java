import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightSideTree {
    public static void main(String[] args) {
        System.out.println(new Solution().rightSideView(new TreeNode()));
    }

    static class Solution {
        List<Integer> solution = new ArrayList<>();
        Map<Integer, Integer> rightVal = new HashMap<>();

        public List<Integer> rightSideView(TreeNode root) {
            int height = 0;
            if (root != null)
                inorderTraverse(root, height);
            while (true) {
                if (!rightVal.containsKey(height))
                    break;
                else
                    solution.add(rightVal.get(height++));
            }
            return solution;
        }

        private void inorderTraverse(TreeNode node, int height) {
            if (node.left != null) {
                inorderTraverse(node.left, height + 1);
            }
            rightVal.put(height, node.val);
            if (node.right != null) {
                inorderTraverse(node.right, height + 1);
            }
        }
    }
}
