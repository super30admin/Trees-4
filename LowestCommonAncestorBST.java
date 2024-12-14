// recursive approach
// time complexity = O(h)
// space complexity = O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    

        if (p.val < root.val && q.val < root.val) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}

// iterative approach
// time complexity = O(h)
// space complexity  = O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(p.val> root.val && q.val> root.val) {
                root = root.right;
            } else if(p.val < root.val && q.val < root.val) { 
                root = root.left;
            } else {
                return root;
            }
        }
        
    }
}