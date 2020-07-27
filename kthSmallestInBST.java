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

//We can use heap but increases time complexity to O(logN)
//Inorder traversal all the elements in sorted order always .
//Put in array and take the largest and smallest element . No need
//Iterative
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
       while(root!= null || !st.isEmpty()){
           while(root!= null){
               st.push(root);
               root = root.left; //assign new root ie left of the current root
           }
           root = st.pop();  // till we reach null ie traveresed and then decrease the k till it becomes 0
           k--;
           if(k == 0 ) return root.val;
           root = root.right;
           
       }
        return -1;
    }
}

/*
Time complexity : O(N)
Space complexity : O(H)
*/