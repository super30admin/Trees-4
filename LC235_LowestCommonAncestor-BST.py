"""
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Every operation that is performed on a Binary tree can be performed on a BST as well.
We can traverse the tree and check if the nodes are on the same or the opposite side of a node. as soon as they are on the opposite side, we found the
LCA

3 cases : 
one node is the root and other node is a right child - root is the LCA 

one node is the root and other node is a left child - root is the LCA 

one node is on the right side and other is on the left side

Time complexity - O(h)
Space Complexity - O(n)

"""
# RECURSIVE APPROACH
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return root
        
         # If both p and q are lesser than parent
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left, p, q)
         # If both p and q are greater than parent
        elif p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right,p, q)
        # We have found the split point, i.e. the LCA node
        else:
            return root


# ITERATIVE APPROACH

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return root
        while True:
            if p.val<root.val and q.val<root.val:
                root = root.left
            elif p.val>root.val and q.val>root.val:
                root = root.right
            else:
                return root
