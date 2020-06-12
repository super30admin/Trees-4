


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Sample {

    // Time Complexity : O(K) K is given K
    // Space Complexity : O(K)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Approach:
     * Since it's binary search tree, we can do inorder traversal and find kth smallest element.
     */

    int result = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null || k < 0){
            return result;
        }
        count = k;
        helper(root);
        return result;
        
    }
    
    private void helper(TreeNode node){
        if(node == null)
            return;
        
        helper(node.left);
        count--;
        if(count == 0) {
            result = node.val;
            return;
        }
        helper(node.right);
        
    }

    // Time Complexity : O(N) N is number of nodes in tree
    // Space Complexity : O(N) size of recursive stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Approach:
     * 1. Since it's binary search tree, we can compare value of p and q with root.
     * 2. If values of p and q are less than root, then traverse to left tree.
     * 2. If values of p and q are greater than root, then traverse to right tree.
     * 3. else the root node is the result.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) {
            return root;
        }
        
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return root;
        }
        
    }


    // Time Complexity : O(N) N is number of nodes in tree
    // Space Complexity : O(N) size of recursive stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Approach:
     * 1. Traverse through the tree till the required nodes are found either on left or right of the 
     * rott node.
     * 2. if the left and right node found, matches to p and q, return that root node.
     * 3. Else keep traversing of left of the tree and right of the tree.
     */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        //base
        if(root == null || p == root || q == root){
            return root;
        }
        
        //Logic
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        
        if(left != null && right != null){
            return root;   
        }
        else if(left != null){
            return left;
        }
        else 
            return right;
    }
}
