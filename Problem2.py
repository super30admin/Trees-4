# Problem 2 : Lowest Common Ancestor of a Binary Search Tree
# Time Complexity :
'''
Recursion- O(n) where n is the number of nodes
Iterative Method- O(n) where n is the number of nodes
'''
# Space Complexity :
'''
Recursion- O(h) where h is the tree of the tree
Iterative Method- O(n) where h is the tree of the tree
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# Using Recursion
 
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # edge case if root is None then return None
        if root is None: return None
        # if the root values is greater then both p and q node then the ancestor is on left of the root
        if root.val > p.val and root.val > q.val:
            # call the function with root.left
            return self.lowestCommonAncestor(root.left, p, q)
        # if the root values is less then both p and q node then the ancestor is on right of the root
        elif root.val < p.val and root.val < q.val:
            # call the function with root.right
            return self.lowestCommonAncestor(root.right, p, q)
        # if p is on left of root and q on right or vice-versa then it means root is the ancestor so return root
        else:
            return root
        

# Iterative soltuion
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # edge case if root is None then return None
        if root is None: return None
        # while loop
        while (True):
            # if the root values is greater then both p and q node then the ancestor is on left of the root
            if root.val > p.val and root.val > q.val:
                # set the root to root.left
                root = root.left
            # if the root values is less then both p and q node then the ancestor is on right of the root
            elif root.val < p.val and root.val < q.val:
                # set the root to root.right
                root = root.right
            # else return root
            else:
                return root
        return None