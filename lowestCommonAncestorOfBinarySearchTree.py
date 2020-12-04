#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(n) where n is number of nodes in the tree
#Did this code successfully run on Leetcode : Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #check if both p and q values are less than root, then we only need to check on the left side of the root
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        #check if both p and q values are greater than root, then we only need to check on the left side of the root
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        #else if either p or q are equal to root or both are on the left and right side of the root, then we've found the lowest common ancestor
        else:
            return root
