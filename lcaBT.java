//Time complexity:O(N) where N is the number of nodes in the tree.
//Space Complexity:O(1)
//In this problem, I'll be checking if root is either equal to p or q. In that case, My root will be the LCA. Then I'll recursively traverse through the right and the left half of the tree and repeat the process. If both the right and left are not null, then the root will be the LCA. Else, if left is not null and right is null, then left value will be the LCA, else right will be the LCA.
//THis code was executed successfully and got accepted in leetcode.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;}
        if(root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        else{
            return right;
        }
    }
}

