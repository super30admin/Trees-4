//Problem:102- Lowest Common Ancestor of a Binary Search Tree
//TC:O(N), worst case, if it is a skewed tree
//SC:O(H), considering recursive stack

/*Steps

*/

class Solution102 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //TC:O(N),SC:O(H), considering recursive stack
        return helper(root,p,q);
        
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        
        if(root==null) return null;
        
        if(root==p || root==q) return root; 
        
        TreeNode left=null;
        TreeNode right=null;
        //because of BST property
        if(p.val<root.val || q.val<root.val){
           left  = helper(root.left,p,q);    
        }
        
        if(p.val>root.val || q.val>root.val){
           right  = helper(root.right,p,q);    
        }
        
        if(left==null) return right;
        
        if(right==null) return left;
        
        return root;
        
    }
    
}