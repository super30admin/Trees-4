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

class Problem2 {
    //TC:O(H)
    //SC : O(H)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recurLcaHelper(root,p,q);
    }

    public TreeNode recurLcaHelper(TreeNode root, TreeNode p, TreeNode q){

        //logic
        if(p.val<root.val && q.val<root.val){
            return recurLcaHelper(root.left,p,q);
        }else if(p.val>root.val && q.val>root.val){
            return recurLcaHelper(root.right,p,q);
        }else return root;



    }
}