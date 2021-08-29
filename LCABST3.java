//Time complexity: O(log N)
//space complexity: O(h) //stack space
//iterative approach

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
        if(root == null)
            return root;
        
        //iterative approach
        while(true){
            if(root.val < p.val && root.val < q.val)
                root = root.right;
            else if(root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
    }
    
 
}