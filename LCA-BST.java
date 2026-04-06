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

// Recursive O(log n) time, O(h) space
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         // both p and q are in right subtree
//         if (root.val < p.val && root.val < q.val) {
//             return lowestCommonAncestor(root.right, p, q);
//         }

//         // both p and q are in left subtree
//         if (root.val > p.val && root.val > q.val) {
//             return lowestCommonAncestor(root.left, p, q);
//         }

//         // otherwise one in left, one in right, then root is LCA
//         return root;
//     }
// }

// Iterative O(log n) time, O(1) space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {
            // both p and q are in right subtree
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            // both p and q are in left subtree
            else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else {
                // otherwise one in left, one in right, then root is LCA
                return root;
            }
        }
        return null;
    }
}