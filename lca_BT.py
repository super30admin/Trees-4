"""
// Time Complexity : O(n) //number of elements
// Space Complexity : O(n) //recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
- Given below
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Since it's a binary tree, we have no way to know the direction of p and q directly.
        So we need to get the sense of p and q by means of left and right subtree, especially check for null( meaning we didn't find the node)
        Base case - if root.val is equal to p or q return root
        left = Recurse left
        right = Recurse right 
        Cases
            1) if root.left and root.right , then return root
            2) if root.left None, return root.right
            3) else return lca(root.left)
        """
        
        if root:
            #base case ( matching p or q)
            if root.val == p.val or root.val == q.val:
                return root
            #process left
            left = self.lowestCommonAncestor(root.left,p,q)
            #process right
            right = self.lowestCommonAncestor(root.right,p,q)
            
            if left and right:
                return root
            elif left and not right:
                return left
            else:
                return right