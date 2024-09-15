//Problem-1

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
//TC:o(n)
//sc:o(maxdepth)


class Solution {
    public int kthSmallest(TreeNode root, int k) 
    {
       Stack<TreeNode> stack = new Stack<>();
       while(root!=null || !(stack.isEmpty()) ){
           while(root!=null)
           {
              stack.push(root);
              root=root.left;    
           }
           TreeNode p = null;
           if(root==null && !(stack.isEmpty()) )
           {  
             p=stack.pop();
             k--;
             if(k==0) 
                 return p.val;
           }
           root = p.right;
       }  
        return -1;
    }
}