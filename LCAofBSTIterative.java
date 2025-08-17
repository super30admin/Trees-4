
// Time Complexity : O(H) -> At most we have to travel to the depth of the tree if the BST is either left skewed or right skewed.
// Space Complexity : O(1) -> There is no recursive stack in this iterative approach.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
        
        //base case
        if(root == null || p == null || q == null){
            return null;
        }

        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }

    }
}