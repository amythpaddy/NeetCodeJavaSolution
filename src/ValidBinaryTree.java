import java.util.ArrayList;
import java.util.List;

public class ValidBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(new TreeNode()));
    }

    static class Solution {
        boolean isValid = true;
        List<Integer> inorder = new ArrayList<>();

        public boolean isValidBST(TreeNode root) {
            if (root != null)
                traverseTree(root);
            for (int i = 1; i < inorder.size(); i++) {
                isValid = inorder.get(i - 1) < inorder.get(i) && isValid;
            }
            return isValid;
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
