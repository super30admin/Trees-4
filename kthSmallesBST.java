/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree. 
 * The tree is traversed multiple times: once to build the new tree with counts 
 * and once to find the k-th smallest element. Both operations involve visiting 
 * each node.
 * 
 * Space Complexity: O(n), where n is the number of nodes in the binary tree. 
 * Space is required for the new tree structure with counts, as well as for recursion 
 * stack space during the tree traversal.
 */

class Node {
    Node left;
    Node right;
    int val;
    int count;

    // Constructor to initialize the value of the node
    Node(int val) {
        this.val = val;
    }
}


class Solution {
    // Main method to find the k-th smallest element in a BST
    public int kthSmallest(TreeNode root, int k) {
        // Build the tree with counts from the original BST
        Node node = buildTree(root);
        // Find the k-th smallest element using the modified tree
        return findKth(node, k);
    }

    // Method to find the k-th smallest element in the tree
    private int findKth(Node node, int k) {
        if (node == null)
            return -1; // If the node is null, return -1 (indicating the element is not found)

        // If k-th smallest element is in the right subtree
        if (node.count < k - 1)
            return findKth(node.right, k - (node.count + 1)); // Adjust k and search in the right subtree
        // If k-th smallest element is in the left subtree
        else if (node.count > k - 1)
            return findKth(node.left, k); // Search in the left subtree
        // If the current node is the k-th smallest element
        else {
            return node.val; // Return the value of the current node
        }
    }

    // Method to build the modified tree with counts from the original BST
    private Node buildTree(TreeNode root) {
        if (root == null)
            return null; // If the root is null, return null

        // Create a new node for the current tree node
        Node node = new Node(root.val);
        // Set the count of nodes in the left subtree
        node.count = dfs(root.left);
        // Recursively build the left and right subtrees
        node.left = buildTree(root.left);
        node.right = buildTree(root.right);
        return node; // Return the newly created node
    }

    // Method to count the number of nodes in the subtree rooted at 'root'
    private int dfs(TreeNode root) {
        if (root == null)
            return 0; // If the root is null, there are no nodes

        // Count nodes in the left and right subtrees
        int countLeft = dfs(root.left);
        int countRight = dfs(root.right);
        // Return the total count of nodes in the subtree, including the current node
        return countLeft + countRight + 1;
    }
}
