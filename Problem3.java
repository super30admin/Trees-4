// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
class Problem3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recurHelper(root,p,q);
    }
    //TC: O(N)
    //SC :O(H)
    public TreeNode recurHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root ==p || root ==q){
            return root;
        }
        TreeNode left = recurHelper(root.left,p,q);
        TreeNode right = recurHelper(root.right,p,q);

        if(left == null && right == null){
            return null;
        }

        if(left != null && right == null){
            return left;
        }else if(right !=null && left == null){
            return right;
        }else{
            return root;
        }
    }
}
