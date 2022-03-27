// Time Complexity : O(h) where h is the height of the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Run while loop untill root is null, check the values of p and q nodes
// If they are less than root move left otherwise move right
// If one of them is less or more we will return the root as the answer

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
        int pV = p.val;
        int qV = q.val;     
        while(root != null){
            int val = root.val;
            if(val > pV && val > qV){
                root = root.left;
            }
            else if( val < pV && val < qV){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
        
    }
}