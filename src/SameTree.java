public class SameTree {
    public static void main(String[] args) {
        System.out.println(new Solution().isSameTree(new TreeNode(1, null, null), new TreeNode(1, null, null)));
    }

    static class Solution {
        boolean isSame = true;

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p != null && q != null) {
                if (p.val == q.val) {
                    isSameTree(p.left, q.left);
                    isSameTree(p.right, q.right);
                } else {
                    isSame = false;
                }
            } else if (p != null || q != null) {
                isSame = false;
            }
            return isSame;
        }
    }
}
