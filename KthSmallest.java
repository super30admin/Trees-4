// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We traverse the BST in InOrder Traversal and use a global count to find the Kth Smallest Element.
*/

class Solution {
    int res;
    int kGlobal;
    public int kthSmallest(TreeNode root, int k) {
        res = -1;
        kGlobal = k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root) {
        if (root == null || res != -1) return;
        traverse(root.left);
        kGlobal--;
        if (kGlobal==0 && res == -1) res = root.val;
        traverse(root.right);
    }
}