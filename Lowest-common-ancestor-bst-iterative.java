// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using dfs, if root is greater than p and q, move left else
// move right or return root if p is in left and q is in the right. 

// 235. Lowest Common Ancestor of a Binary Search Tree

// Iterative

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Iterative
        while(true){
            if(root.val > p.val && root.val > q.val){
            root = root.left;
        }
        else if(root.val < p.val && root.val < q.val){
            root = root.right;
        }
        else{
            return root;
        }
        }  
    }
}