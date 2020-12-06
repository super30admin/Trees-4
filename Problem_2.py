"""
Time Complexity : O(logn)
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I have done both iterative and recursive solution here. We just need to compare values of p and q with the 
root. If both are greater than the root, we need to go to the right. If both are smaller than the root,
we need to go to the left. If one is smaller and one is greater, that mean we are at the right position
and the current root is the lowest common ancestor of the given numbers
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root
# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         while root:
#             if root.val<p.val and root.val<q.val:
#                 root=root.right
#             elif root.val>p.val and root.val>q.val:
#                 root=root.left
#             else:
#                 return root
#         return None
