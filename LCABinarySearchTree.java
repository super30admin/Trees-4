// Time Complexity : O(h)
// Space Complexity :O(h)
//h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Recursive Approach
//TC: O(h) h is the height of the tree
//SC: O(h)
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

        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);

        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);

        else
            return root;
    }
}

//Iterative Approach
//TC: O(h) h is the height of the tree
//SC: O(1)
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