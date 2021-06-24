/**
================================= Recursive approach ==========================================
Time: O(H) 
Space: O(H) stack space 
Approach:
========
1. Use technique that LCA would be in the middle of p and q value-wise
2. If one of them is smaller, the other is larger, return root
3. If both are larger than root, search in right subtree
4. If both are smaller than root, search in left subtree
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) 
            return root;
        
        if(p.val < root.val && q.val < root.val)            // both are lower than root value, so search in left subtree
            return lowestCommonAncestor(root.left, p , q);
        else if(p.val > root.val && q.val > root.val)       // both are larger than root value, so search in right subtree
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;                        // found LCA
    }
}


/**
================================= Iterative approach ==========================================
Time: O(H) 
Space: O(1) space 
Approach:
========
1. Use technique that LCA would be in the middle of p and q value-wise
2. If one of them is smaller, the other is larger, return root
3. If both are larger than root, search in right subtree
4. If both are smaller than root, search in left subtree
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val < root.val && q.val < root.val) 
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}