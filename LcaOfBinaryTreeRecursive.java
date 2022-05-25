//bottom-up recursion -> every left and right node will return values to the parent node hence the name
//excellent solution for such a simple problem!
// at every root i'm just checking its immediate neightboru left snd right nodes recursively 
//tc: o(n) sc: o(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null || root == p || root == q) {
           return root;
       } 
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null) {
            return null;
        }
        else if(left != null && right == null) {
            return left;
        }
        else if(left == null && right != null) {
            return right;
        }
        else return root;
    }
}
