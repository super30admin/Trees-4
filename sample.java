// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: traverse BST in inorder traversal, 
// this would give values in increasing order and kth smallest elem would be kth element in this order.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int val = 0;
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        func(root,k);
        return val;
    }
    public void func(TreeNode node, int k){
        if(node==null) return;
        func(node.left,k);
        count++;
        if(count==k){
            val=node.val;
            return;
        }
        func(node.right,k);
    }
}

// Time Complexity : O(n/2)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: A node in a BST is an ancestor of 2 nodes p, q, iff p and q lie on different sides of the tree.
// if both p,q lies on left then lca is in left side of root and vice versa
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
