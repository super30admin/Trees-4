/* Time Complexity: O(n)
 * Space Complexity: O(h), recursive stack space
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

import java.util.ArrayList;
import java.util.List;

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
        if(root == null || root == p || root == q) return root;
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        else if(left != null && right == null) return left;
        else if(left == null && right != null) return right;
        else return root;
    }
}

/*
 *For c++ people with flags: 

 bool lowestCommonAncestorRecur( TreeNode* root, TreeNode* p, TreeNode* q,
                                          bool pflag, bool qflag, TreeNode** answer ) {
        if( root == nullptr ){
            return false;
        }
        pflag = lowestCommonAncestorRecur( root->left, p, q, pflag, qflag, answer );
        qflag = lowestCommonAncestorRecur( root->right, p, q, pflag, qflag, answer );
        bool curr = root == p || root == q;
        if( *answer == nullptr && ( ( pflag && curr ) || ( qflag && curr ) || ( pflag && qflag ) ) ){
            *answer = root;
        }
        if( root == p ){
            pflag = true;
        }
        if( root == q ){
            qflag = true;
        }
        return pflag || qflag;
    }
 */
*/