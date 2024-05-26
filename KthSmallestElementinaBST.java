
 //Definition for a binary tree node.

import java.util.Stack;

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
 
 //Time : O(N)
 //space: O(Height)
 class Solution {
    int count;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty())
        {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0)
            {
                return root.val;
            }
            root = root.right;
        }
        return 889;
    }
}