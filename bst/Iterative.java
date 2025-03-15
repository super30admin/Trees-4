package bst;

//The approach here is to check if the left child and right child exist to the same side of root at each iteration, so we eliminate one half of the tree while searching for ancestor
//Time Complexity:O(n) where n is the number of nodes in the tree
//Space Complexity:O(1)

class Iterative {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        while(true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}