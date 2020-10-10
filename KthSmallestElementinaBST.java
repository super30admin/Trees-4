//Time Complexity-O(V+E)
//Space Complexity=O(Max depth of tree)
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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
        {
            return 0;
        }
        Stack<TreeNode>stack=new Stack();
        while(!stack.isEmpty()||
             root!=null)
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            TreeNode popped=stack.pop();
            k--;
            if(k==0)
            {
                return popped.val;
            }
            root=popped.right;
        }
        return -1;
        
    }
}