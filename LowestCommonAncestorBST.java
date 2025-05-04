// Time Complexity : O(h) where h = ht of BST
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Start at the root node and traverse down the tree.
//   - If both p and q values are less than root, LCA lies in the left subtree.
//   - If both p and q values are greater than root, LCA lies in the right subtree.
//   - If p and q are on opposite sides (or one equals the root), then the current root is the LCA.


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;        // Node with val = 2
        TreeNode q = root.left.right;  // Node with val = 4

        LowestCommonAncestorBST obj = new LowestCommonAncestorBST();
        TreeNode lca = obj.lowestCommonAncestor(root, p, q);
        System.out.println("LCA = " + lca.val);
    }
}
