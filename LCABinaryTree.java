// the time complexity of this implementation is O(N) where
// N is the number of nodes
import javax.swing.tree.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }

        // If the root is either p or q, return the root
        if (root == p || root == q) {
            return root;
        }

        // Recursively search for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q are in different subtrees, return the current node
        if (left != null && right != null) {
            return root;
        }

        // If p and q are in the same subtree, continue the search in that subtree
        return left != null ? left : right;
    }
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Find the lowest common ancestor of nodes 5 and 1
        TreeNode p = root.left;
        TreeNode q = root.right;
        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("The lowest common ancestor of nodes " + p.val + " and " + q.val + " is " + lca.val);
    }

}
