# 235. Lowest Common Ancestor of a Binary Search Tree
# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

# Logic: We use the property of a BST that the left child is less than node and 
# right child is more than the root. There are 3 cases possible, p and q lie on 
# the left, they lie on the right or they lie on either side. If there are not 
# on the same side, then we know the current node is the LCA. If they both lie 
# on the left, we more the current node towards the left and same for right. 
# Then we again check root value with p and q.

# Time Complexity: O(h)
# Space Complexity: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:         
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root