package Trees-4;
// Time Complexity : O(n) n is number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class LowestCommonBST {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode node = root;
        while(node!=null)
        {
            if(p.val<node.val && q.val<node.val)
            {
                node = node.left;
            }else if(p.val>node.val && q.val>node.val)
            {
                node = node.right;
            }else
            {
                return node;
            }
        }
     return null;   
    }
}
    
}
