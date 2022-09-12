//TC - O(LogN);
//SC - O(1);
//LC - 235

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
        int max = Math.max(p.val,q.val);
        int min = Math.min(p.val,q.val);
        
        while(true){
            if(root.val<min){
                root=root.right;
            }
            else if(root.val>max){
                root=root.left;
            }
            else
                return root;
        }
        
    }
}