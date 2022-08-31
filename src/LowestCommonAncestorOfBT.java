// Time Complexity:  O(n)
// Space Complexity: O(h)
// where n is number of nodes in tree, h is height of tree

/**
 * Definition for a binary tree node.
 *  */

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }

        if(root == p || root == q) {                                    // root is either of p or q
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);          // check for p, q in left child
        TreeNode right = lowestCommonAncestor(root.right, p, q);        // check for p. q in right child

        if(left != null && right != null) {                             // both children got p, q
            return root;
        }

        return left == null ? right : left;                             // return either of child eho is not null
    }
}
