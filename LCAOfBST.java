//TC: O(n), SC: O(1)
//Approach: Since root is a valid BST, the values to the left of the root are smaller than left, to the right are > than root
//if p and q are smaller than root, we need to search in the left subtree, else if they both are on the right then right subtree
//else root is the LCA
public class LCAOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
