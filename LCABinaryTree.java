//space complexity is O(N)
//time complexity is O(N)
class Solution {
    TreeNode result =null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        int left = helper(root.left, p,q)?1:0;
        int right = helper(root.right, p, q)?1:0;
        int mid = (root==p || root==q)?1:0;
        if((left+right+mid)>=2 ){
            result=root; 
        }
        return (left+right+mid)>0;
    }
}