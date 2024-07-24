//TC - O(h)
//O(log N) - balanced BST
//O(N) - skewed BST 
//SC - O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root.val > p.val && root.val > q.val){
            root = root.left;
        }
        else if(root.val < p.val && root.val < q.val){
            root = root.right;
        }
        else{
            return root;
        }

    return root;
}
}