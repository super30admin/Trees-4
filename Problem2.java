//Time : O(n)
//Space : O(1)

//Approach:
// 1.Since tree is a BST we check if both the values are on either side then we make a recursive call to that side.
// 2. Else if they are on opposite side of the current node, then the current node will be common ancestor.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }
}
