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

//TC: O(k)
//SC: O(k)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack();
        
        while(!st.isEmpty() || root!=null){
            while(root!= null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) return root.val;
            root = root.right;
        }
        return -1;
    }
}


class Solution {
    int count; int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        count--;
        if(count==0) {
            result = root.val;
            return;
        } 
        inorder(root.right);
    }
}
