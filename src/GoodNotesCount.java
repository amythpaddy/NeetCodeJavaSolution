public class GoodNotesCount {

    public static void main(String[] args) {
        System.out.println(new Solution().goodNodes(new TreeNode()));
    }

    static class Solution {
        int goodNoteCount = 0;

        public int goodNodes(TreeNode root) {
            if (root != null) {
                traverseNodes(root, root.val);
            }
            return goodNoteCount;
        }

        private void traverseNodes(TreeNode root, int maxVal) {
            if (root.val >= maxVal)
                goodNoteCount++;
            if (root.left != null)
                traverseNodes(root.left, Math.max(maxVal, root.val));
            if (root.right != null)
                traverseNodes(root.right, Math.max(maxVal, root.val));
        }
    }
}
