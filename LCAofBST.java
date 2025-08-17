
// Time Complexity : O(H) -> At most we have to travel to the depth of the tree if the BST is either left skewed or right skewed.
// Space Complexity : O(H) -> 
        //recursively iterate over the tree based on the satifying condition, so underlying stack can atmost take number of nodes equals height of the tree.
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

        TreeNode answer = lca(root, p, q);

        return answer;

    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root == null){
            return null;
        }

        //logic
        else if(root.val < p.val && root.val < q.val){
            return lca(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val){
            return lca(root.left, p, q);
        }
        else{
            return root;
        }

    }
}