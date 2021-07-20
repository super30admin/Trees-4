package Trees4;

import java.util.Stack;

public class question101_KthSmallestElementBST {
    /* Created by palak on 7/19/2021 */

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
        Time Complexity: O(h + k)/ O(N)
        Space Complexity: O(n)
    */
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while( root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0) return root.val;
            else root = root.right;
        }
        return -1;
    }

    /*
        Time Complexity: O(h + k)/ O(N)
        Space Complexity: O(n)
    */
    int result;
    int count;
    public int kthSmallest2(TreeNode root, int k) {
        result = -1;
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k) {
        //Base
        if(root == null) return;
        //Logic
        if(result == -1) {
            inorder(root.left, k);
        }
        count++;
        if(count == k)  result = root.val;
        if(result == -1) {
            inorder(root.right, k);
        }
    }

    public static void main(String[] args) {

    }
}
