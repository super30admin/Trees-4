/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC : O(logn)
// SC : O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;
        
        Stack<TreeNode> st = new Stack<>();
        
        //st.push(root);
        while(true) {
            
            if((root.val >= p.val && root.val <= q.val)
               || (root.val <= p.val && root.val >= q.val))
                return root;
            
            else if(root.val > p.val && root.val > q.val)
                root = root.left;
            else 
                root = root.right;
            
        }
        //return root;
    }
}
