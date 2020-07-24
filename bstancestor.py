# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# STEPS:
# Perform a pre-order traversal.
# if the value of p and q match with the root. return the root.
# if the value of p and q is less than the root, move to the left.
# if the value of p and q is greater than the root, move to the right.
# if one of the value out of p and q is less than the root and other is greater than the root, return the root.

# recursive solution
# time complexity - O(h)
# space complexity - O(h)
# did this code successfully run on leetcode? - yes
# any issues faced? - no
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root.val <= p.val and root.val >= q.val) or (root.val >= p.val and root.val <= q.val) :
            return root
        elif (root.val > p.val and root.val > q.val):
            return self.lowestCommonAncestor(root.left, p, q)
        elif (root.val < p.val and root.val < q.val):
            return self.lowestCommonAncestor(root.right, p, q)
        
        
# iterative solution
# no need to use stack here.  
# time complexity - O(h)
# space complexity - O(1)
# did this code successfully run on leetcode? - yes
# any issues faced? - no
from collections import deque
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        nodes_stack = deque()
        
        while root:
            if (root.val <= p.val and root.val >= q.val) or (root.val >= p.val and root.val <= q.val):
                return root
            elif (root.val > p.val and root.val > q.val):
                root = root.left
            elif (root.val < p.val and root.val < q.val):
                root = root.right
        
        return 
            