class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    //First method
    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val > root.val)
            return root;
        // it is wrong when i do not add " return "
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q); 
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    // Time complexity: O(n)
    // Space complexity: O(1)

    // Second method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }
    
}