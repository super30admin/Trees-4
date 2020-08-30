# APPROACH  1: RECURSIVE
# Time Complexity : O(lg n), n: number of nodes in tree (as we are rejecting half of the tree each time by choosing one side ove the other)
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Lowest common ancestor is that node, for which both the nodes lie on either side of it
# 2. So keep doing this till both nodes are not on same side
# 3. If both nodes are less than the current root, move to left child, else move to right child.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root is None:
            return None
        
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
            
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        
        else:
            return root
            




# APPROACH  2: ITERATIVE
# Time Complexity : O(lg n), n: number of nodes in tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same approach as the above but in iterative manner.
# 2. Do this till current root is None or answer is found. 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root is None:
            return None
        
        while root is not None:
            if p.val < root.val and q.val < root.val:
                root = root.left
                
            elif p.val > root.val and q.val > root.val:
                root = root.right
                
            else:
                return root
