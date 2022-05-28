/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursive Approach
class Solution {

    // Time Complexity : 0(h) since in we can make a choice of going to left subtree of going to right subtree or returning root
// Space Complexity : 0(h) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){   //checking if the root's value is greater than the ancestor lies in the left part
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){  //if root is smaller, then it lies in right part
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;    //if either value is smaller and bigger than root means 1 value lie in right subtree and 1 in left. So we return root
        }
    }
}

//Iterative approach

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

    // Time Complexity : 0(h) since in we can make a choice of going to left subtree of going to right subtree or returning root
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
