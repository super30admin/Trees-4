// Time Complexity : The time complexity of the lowestCommonAncestor function is O(log N) for a balanced binary search tree (BST) and O(N) for a skewed BST, where N is the number of nodes in the tree. In each recursive call, we eliminate half of the nodes by traversing either the left or right subtree
// Space Complexity :  The space complexity of the lowestCommonAncestor function is O(log N) for a balanced binary search tree (BST) and O(N) for a skewed BST. This space is used for the call stack during the recursive calls. In the worst case, the call stack can grow to the height of the tree, which is log N for a balanced BST and N for a skewed BST.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Any problem you faced while coding this: The implementation appears to be correct for a binary search tree (BST). However, it is important to note that the approach assumes the given tree is a BST, and it may not work correctly for a general binary tree. For a BST, the LCA can be found efficiently by traversing down the tree based on the values of nodes p and q. However, for a general binary tree, finding the LCA requires a different approach, such as using the method implemented in the LCA_BT class.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Check if both nodes are smaller than the current node, search in the left
        // subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // Check if both nodes are greater than the current node, search in the right
        // subtree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Nodes are on different sides of the current node, current node is the LCA
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Create an instance of LCA_BST
        LCA_BST lca_bst = new LCA_BST();
        // Find the lowest common ancestor (LCA) of two nodes in the BST
        TreeNode p = root.left; // Example: Node with value 2
        TreeNode q = root.left.right.right; // Example: Node with value 5
        TreeNode lcaNode = lca_bst.lowestCommonAncestor(root, p, q);
        // Print the value of the lowest common ancestor (LCA)
        System.out.println("The lowest common ancestor of nodes " + p.val + " and " + q.val + " is: " + lcaNode.val);
    }
}
