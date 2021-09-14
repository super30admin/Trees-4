/*
Time: O(H) Recursive stack
Space: O(H) height of tree
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case: 
        if(root==null){
            return root;
        }
        //Algorithm
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);  
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);  
        }
        return root;
    }
}
