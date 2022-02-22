//https://leetcode.com/submissions/detail/644930946/
// Time: O(n)
//Space: O(n) height of tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    public int KthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(stack.Count > 0 || root !=null ){
            
            while(root != null) {
                stack.Push(root);
                root = root.left;
            }
            
            k--;
            
            root = stack.Pop();
            
            if(k == 0) {
                return root.val;
            }
            
            root = root.right;
        }
         return -1;
    }
    
}