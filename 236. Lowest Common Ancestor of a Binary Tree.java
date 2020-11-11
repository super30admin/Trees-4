class Solution {// Time and space of O(n)
    private TreeNode result;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return result;
    }
    private boolean helper(TreeNode node, TreeNode p, TreeNode q){
        //Base case
        if(node == null)
            return false;
        
        int left = (helper(node.left,p,q)?1:0);
        int right = (helper(node.right,p,q)?1:0);
        int root ;
        root = ((node.val == p.val)|| (node.val)== q.val)?1:0;
        if(left+ right + root >=2){
            this.result = node;
        }
        return (left+ right +root >0);
        // Have a doubt in this return statement can you tell me why we checking if its  >0
    }
}