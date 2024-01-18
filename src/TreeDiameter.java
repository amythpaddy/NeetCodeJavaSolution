import com.sun.source.tree.Tree;

public class TreeDiameter {

    public static void main(String[] args) {
        System.out.println(new Solution().diameterOfBinaryTree(new TreeNode(1, null, null)));
    }

    static class Solution {
        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            processTree(root);
            return maxDiameter;
        }

        public int processTree(TreeNode root) {
            int previousHeightLeft = -1;
            int previousHeightRight = -1;
            if (root.left != null)
                previousHeightLeft = processTree(root.left);
            if (root.right != null)
                previousHeightRight = processTree(root.right);
            maxDiameter = Math.max(previousHeightLeft + previousHeightRight + 2, maxDiameter);

            return (Math.max(previousHeightLeft, previousHeightRight) + 1);
        }
    }
}
