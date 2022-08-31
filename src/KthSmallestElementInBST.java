// Time Complexity:  O(n)
// Space Complexity: O(h)
// where n is number of nodes in tree, h is height of tree

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * */
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


public class KthSmallestElementInBST {

    private int k;
    private int ans;

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while(root != null) {
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            k--;
            if(k == 0)                             // got the kth smallest element
                return node.val;
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return -1;
    }

// ****************************** ANOTHER APPROACH ******************************
//    public int kthSmallest(TreeNode root, int k) {
//
//        this.k = k;
//        ans = -1;
//
//        inorder(root);
//
//        return ans;
//    }
//
//    private void inorder(TreeNode node) {
//
//        if(node == null)
//            return;
//
//        inorder(node.left);
//
//        k--;
//        if(k == 0) {                         // kth smallest element
//            ans = node.val;
//            return;
//        }
//
//        inorder(node.right);
//
//    }
}
