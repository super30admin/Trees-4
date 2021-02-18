# Time Complexity : O(log n)
# Space Complexity : O(n) considering stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# At each subtree I check if root is greater than both the elements. If yes, the got to right subtree else if both are smaller, go to left subtree, if one
# is smaller and other is greater return current root up the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        
        def helper(root, p, q):
            if q.val < p.val:
                return helper(root, q, p)
                
            if not root:
                return None
            
            if root.val >= p.val and root.val <= q.val:
                return root
            
            if root.val > p.val and root.val > q.val:
                return helper(root.left, p, q)
            
            if root.val < p.val and root.val < q.val:
                return helper(root.right, p, q)
            
        return helper(root, p, q)
