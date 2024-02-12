// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pNode, TreeNode qNode) {
        TreeNode node = root;
        int p = pNode.val;
        int q = qNode.val;

        while(true){
            if(node.val == p || node.val == q){
                return node;
            }
            if((node.val < p && node.val > q) || (node.val > p && node.val < q)){
                return node;
            }
            if(node.val < p && node.val < q){
                node = node.right;
            } else node = node.left;
        }

    }
}
