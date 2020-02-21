
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Time complexity : O(n)
 * Space Complexity  : O(H) -- > Height of tree(Stack space) 	
 */
class LowestCommonAncestor_BT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        //Base case
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        
        //Logic
        TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSide = lowestCommonAncestor(root.right, p, q);
        
        if(leftSide != null && rightSide != null){
            return root;
        }
        
        
        if(leftSide != null){
            return leftSide;
        }else if(rightSide != null){
            return rightSide;
        }
        
        return null;
        
    }
}
