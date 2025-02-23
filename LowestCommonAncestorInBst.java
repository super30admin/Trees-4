
/**
 * Time Complexity: O(H), height of tree
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * In a BST root's left is always smaller than root.val and right is always bigger than root.val.
 * Utilizing this property to find the ancestor of given nodes
 */

public class LowestCommonAncestorInBst {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        while (true) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }

    public static void main(String[] args) {
        // Your code here
        LowestCommonAncestorInBst obj = new LowestCommonAncestorInBst();
        TreeNode n4 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, new TreeNode(1), n4);
        TreeNode n1 = new TreeNode(4, n2, new TreeNode(5));
        TreeNode result = obj.lowestCommonAncestor(n1, n2, n4);
        System.out.println(result.val);
    }
}