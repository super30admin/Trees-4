class KthSmallest {
    //Idea is to use property of BST to locate the ancestor. 
    // If node falls between leftnode and rightnode we return it.
    //Time Complexity: O(log(n))
    //Space Complexity: O(log(n)) 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (true) {
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
    }
}