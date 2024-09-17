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
//Iterative Solution
//Time Complexity: O(N)
//Space Complexity: O(1)
/*
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0){
            return root.val;   
            }
            root = root.right;
        }   
        return -1;
    }
}
*/

//Recursive solution: 
//Time complexity: O(N)
//Space Complexity: O(1)

class Solution{
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k){
        count = k;
        inorderTraversal(root);
        return result;
    }
    private void inorderTraversal(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        inorderTraversal(root.left);
        //stack.pop() under the hood this happens after this;
        count--;
        if(count ==0){
            result = root.val;
            return;
        }
        inorderTraversal(root.right);
    }
}


