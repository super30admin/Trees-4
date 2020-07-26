// Time Complexity :O(n) // n-number of nodes
// Space Complexity :O(h) Stack Space // h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//Recursive Approach
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
    int i,result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k); 
        return result;
    }
    
    public void inorder(TreeNode root,int k)
    {
        if(root==null) return;
        
        //logic
        inorder(root.left,k);
        if(root!=null) i++;  
        if(k==i) result=root.val;
        inorder(root.right,k);
    }
}

//Iterative Approach 
TC:O(n)
SC:O(h)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        while(!st.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            k--;
            root=st.pop();
            if(k==0) return root.val;
            root=root.right;
        }
        return 0;
    }
}