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

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

// ****************************** APPROACH 01 ******************************
        while(root != null) {
            if(p.val < root.val && q.val < root.val) {                 // left subtree
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val) {            // right subtree
                root = root.right;
            }
            else {
                return root;                                           // it is the answer node
            }
        }
        return null;

// ****************************** APPROACH 02 ******************************
//        if(p.val < root.val && q.val < root.val) {                 // left subtree
//            return lowestCommonAncestor(root.left, p, q);
//        }
//        else if(p.val > root.val && q.val > root.val) {            // right subtree
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        return root;                                               // it is the answer node


// ****************************** APPROACH 03 ******************************
//        if(root == null) {
//            return root;
//        }
//
//        if(root == p || root == q) {                                    // root is either of p or q
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);          // check for p, q in left child
//        TreeNode right = lowestCommonAncestor(root.right, p, q);        // check for p. q in right child
//
//        if(left != null && right != null) {                             // both children got p, q
//            return root;
//        }
//
//        return left == null ? right : left;                             // return either of child which is not null
    }
}