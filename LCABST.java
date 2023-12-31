//Time Complexity:O(log n)
//Space complexity:O(1)
//Iterative Approach
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
        if(p.val <root.val && q.val <root.val )  root = root.left;
        else if(p.val >root.val && q.val >root.val ) root = root.right;
        else {
           break;
        }
        }
    return root;
    }
}
//Time Complexity:O(log n)
//Space complexity:O(h), h - height of tree
//Recursive  Approach
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
        if(p.val <root.val && q.val <root.val ) return lowestCommonAncestor(root.left,p,q);
        else if(p.val >root.val && q.val >root.val ) return lowestCommonAncestor(root.right,p,q);
        else return root;

    }
}