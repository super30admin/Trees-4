//Time Complexity : O(logn)
//Space Complexity : O(1)

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
  
    if(root.val > Math.max(node1.val, node2.val)){
        return lowestCommonAncestor(root.left, node1, node2);
   }else if(root.val < Math.min(node1.val, node2.val)){
       return lowestCommonAncestor(root.right, node1, node2);
    }
     return root;
    }
}