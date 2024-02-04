import java.util.ArrayList;
import java.util.List;

public class BstKSmallest {
    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new TreeNode(), 0));
    }

    static class Solution {
        List<Integer> inorder = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            if (root != null)
                traverseTree(root);

            return inorder.get(k - 1);
        }

        public void traverseTree(TreeNode node) {
            if (node.left != null) {
                traverseTree(node.left);
            }
            inorder.add(node.val);
            if (node.right != null) {
                traverseTree(node.right);
            }
        }
    }
}
