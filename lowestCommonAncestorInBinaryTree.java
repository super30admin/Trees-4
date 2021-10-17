// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * 
 */

public class lowestCommonAncestorInBinaryTree {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
        traverse(root,p,q);
        return result;
    }

    private boolean traverse(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false; 
        }

        boolean left = traverse(root.left,p,q);
        boolean right = traverse(root.right,p,q);

        if(left && right){ 
            result = root;
        }

        if(root.equals(p) || root.equals(q)){
            if(left || right){ 
                result = root;
                return false;
            }
            return true; 
        }

        return left || right;
    } 
}
