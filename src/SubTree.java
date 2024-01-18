import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubTree {
    public static void main(String[] args) {
        System.out.println(new Solution().isSubtree(new TreeNode(1, null, null), new TreeNode(1, null, null)));
    }

    static class Solution {
        List<Integer> inOrderSubTree = new ArrayList<>();
        List<Integer> inOrderTree = new ArrayList<>();

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root != null)
//                traverseTree(root, inOrderTree);
                if (subRoot != null)
//                traverseTree(subRoot, inOrderSubTree);
                    for (int i = 0; i < inOrderTree.size(); i++) {
                        int startIndex = i;
                        if (Objects.equals(inOrderTree.get(i), inOrderSubTree.getFirst())) {
                            boolean isSubtree = true;
                            for (int j = 1; j < inOrderSubTree.size(); j++) {
                                try {
                                    if (!Objects.equals(inOrderSubTree.get(j), inOrderTree.get(++startIndex))) {
                                        isSubtree = false;
                                        break;
                                    }
                                } catch (IndexOutOfBoundsException ex) {
                                    isSubtree = false;
                                }
                            }
                            if (isSubtree)
                                return isSubtree;
                        }
                    }
            return false;
        }

        public void traverseTree(TreeNode node, TreeNode subTree) {
            if (node.left != null) {
                traverseTree(node.left, new TreeNode());
            }
            if (node.val == subTree.val) {
                compareForSubtree(node, subTree);
            }
//            list.add(node.val);
            if (node.right != null) {
                traverseTree(node.right, new TreeNode());
            }
        }

        public void compareForSubtree(TreeNode tree, TreeNode subTree) {

        }
    }
}
