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
//base
        if(root == null || p.val == root.val || q.val == root.val){ //either found p or q and then return root
            return root;
        }
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left,p,q);  //find p and q on left side
        TreeNode right = lowestCommonAncestor(root.right,p,q);//find p and q on right side
        
        if(left != null && right != null) return root;
        else if(left!= null) return left;
        else if(right!= null) return right;
        else return null;
    }
}

/*
Time complexity: O(N) in worst case traverse entire tree
Recursive stack space : O(H)
*/