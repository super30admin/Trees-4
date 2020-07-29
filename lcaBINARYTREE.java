//Time complexity:O(n)
//Space complexity:O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p.val==root.val || q.val==root.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        else if(right!=null){
            return right;
        }
        return null;
    }
}