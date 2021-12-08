// 235 Lowest common ancestor of a BST
// Time - O(h)
// Space - O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p , q);
        }else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p , q);
        }else{
             return root;
        }
        
       
    }
}