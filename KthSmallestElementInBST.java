/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        // Time Complexity : O(N) N: length of String
// Space Complexity : O(logN)  tree height -> worst case k = N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 PreOrder:
 1. Use HashMap to store char and index of current pointer(f
 2. 
 */
    int count; int result;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        preOrder(root,k);
        return result;
    }
    
    private void preOrder(TreeNode root,int k){
        if(root == null){
            return;
        }
        preOrder(root.left,k);
        count++;
        if(count == k)
            result = root.val;
        preOrder(root.right,k);
    }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        // Time Complexity : O(N) N: length of String
// Space Complexity : O(logN)  tree height -> worst case k = N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 PreOrder Iterative:
 1. Do preorder order traversal till k times and return the poped root val.
 */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
    
}