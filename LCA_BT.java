// Time Complexity : The time complexity of the lowestCommonAncestor function is O(n) because we traverse all nodes in the binary tree. In the worst case, we may need to visit all nodes to find the lowest common ancestor.
// Space Complexity :  The space complexity of the recursive call stack is O(h), where h is the height of the binary tree. In the worst case, the height of the binary tree can be equal to the number of nodes, leading to O(n) space complexity in the worst case. In a balanced binary tree, the height is log(n), resulting in O(log(n)) space complexity.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: The code implements a function lowestCommonAncestor to find the lowest common ancestor (LCA) of two nodes p and q in a binary tree. The binary tree is represented using the TreeNode class, which has a value val, a left child left, and a right child right.
// The function lowestCommonAncestor is implemented using a recursive approach. It starts from the root of the tree and traverses down to find the LCA of the two given nodes p and q.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// public class LCA_BST {
public class LCA_BT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If root is null or p/q is found, return root
        if (root == null || root == p || root == q) {
            return root;
        }
        System.out.println(root.val);
        // Recursively search in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // // If both p and q are found in different subtrees, root is the LCA
        // if (left != null && right != null) {
        // return root;
        // }

        // // If only one of p or q is found, return that node (LCA not found yet)
        // return (left != null) ? left : right;

        // //Below is detailed of above concisely written conditionals
        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (right != null && left == null)
            return right;
        else
            return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Nodes whose LCA needs to be found
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        // Create an instance of LCA_BT to find the LCA
        LCA_BT lcaFinder = new LCA_BT();
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        // Print the value of the lowest common ancestor
        System.out.println("Lowest Common Ancestor: " + lca.val); // The output should be 5
    }

}
