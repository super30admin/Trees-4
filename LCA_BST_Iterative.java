/*
## Problem 2: Lowest Common Ancestor of a Binary Search Tree 
(https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

Time Complexity :   O (h) 
Space Complexity :  O (h) 
Did this code successfully run on Leetcode :    Yes (235. Lowest Common Ancestor of a Binary Search Tree)
Any problem you faced while coding this :       No
 */
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
    
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val < p.val && root.val < q.val)
                root = root.right;
            else if(root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
    }
}