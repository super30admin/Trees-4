// Time Complexity : The time complexity of the kthSmallest function is O(H + k), where H is the height of the Binary Search Tree. This is because the function performs an inorder traversal of the BST, visiting each node once until it finds the kth smallest element or completes the traversal.
// Space Complexity : The space complexity of the kthSmallest function is O(H), where H is the height of the Binary Search Tree. This is because the function uses a recursive approach to perform the inorder traversal, and the maximum space required in the call stack is equal to the height of the BST.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:  The kthSmallest function performs an inorder traversal of the BST to find the kth smallest element. It initializes a global count variable to k and a global result variable to store the kth smallest element found so far. During the inorder traversal (inorder function), the code checks if the current node is null (base case) and returns if it is.
// While traversing the BST in an inorder manner, the code decrements the count variable for each node visited. When the count variable becomes 0, it means the kth smallest element is found, and the result variable is updated with the current node's value. The code continues the inorder traversal but returns immediately if the result is not null. This is done to avoid unnecessary traversals once the kth smallest element is found.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallestInBST {
    int count;
    TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result.val;
    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;

        // logic
        if (result == null)
            inorder(root.left);

        count--;
        if (count == 0) {
            result = root;
        }

        if (result == null)
            inorder(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        // Create an instance of KthSmallestInBST
        KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();

        // Find the kth smallest element in the BST
        int k = 3; // Example: Find the 3rd smallest element
        int kthSmallestValue = kthSmallestInBST.kthSmallest(root, k);

        // Print the result
        System.out.println("The " + k + "th smallest element in the BST is: " + kthSmallestValue);
    }
}