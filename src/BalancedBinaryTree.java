public class BalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution().isBalanced(new TreeNode(1, null, null)));
    }

    static class Solution {
        boolean balanced = true;

        public boolean isBalanced(TreeNode root) {
            if (root != null) {
                checkIsBalanced(root);
            }
            return balanced;
        }

        public int checkIsBalanced(TreeNode tn) {
            if (!balanced) {
                return -1;
            }
            int leftHeight = -1;
            int rightHeight = -1;
            if (tn.left != null)
                leftHeight = checkIsBalanced(tn.left);
            if (tn.right != null)
                rightHeight = checkIsBalanced(tn.right);
            balanced = Math.abs(leftHeight - rightHeight) <= 1;
            return (Math.max(leftHeight, rightHeight) + 1);
        }
    }

}
