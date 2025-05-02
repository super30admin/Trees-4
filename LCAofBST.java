

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
//recustion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parent = root.val;
        int pval=p.val;
        int qval=q.val;
        if(pval>parent && qval>parent){
            return lowestCommonAncestor(root.right,p,q);
        }else if(pval<parent && qval<parent){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
*/

//iteration
//TC:O(logn)
//SC: O(1)
class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }

        while(true){
            if(root.val>p.val && root.val>q.val){
                root=root.left;
            }else if(root.val<p.val && root.val<q.val){
                root=root.right;
            }else{
                return root;
            }
        }
        
    }
}