# Binary Search Tree = 
# left subtree contain only nodes with values less than the parent's nodes values
# right subtree contains only nodes with values greater than parent's nodes values
# 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# iterative:

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        curr = root
        while curr: 
            if p.val > curr.val and q.val > curr.val:
                # go right
                curr = curr.right 
            elif p.val < curr.val and q.val < curr.val:
                # go left
                curr = curr.left 
            else:
                return curr


# recursive:


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
            
        # If both p and q are smaller than root, LCA must be in the left subtree
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q) # bubble result up by returning
            
        # If both p and q are larger than root, LCA must be in the right subtree
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q) # bubble result up by returning
            
        # "Split" point: either p and q are on different sides of root,
        # or one of them IS the root. This means current root is the LCA.
        return root