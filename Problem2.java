

//Time Complexity: O(h) where h is the height of the tree
//Space Complexity: O(h) where h is the height of the tree

//We use the properties of BST to find the lowest common ancestor. 
//If both p and q are smaller than root, then LCA lies in left subtree.
//If both p and q are greater than root, then LCA lies in right subtree.
//If one of p or q is smaller than root and the other is greater, then root is the LCA.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val || root.val==q.val)
            return root;
        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
          
        return root;
        
    }
}