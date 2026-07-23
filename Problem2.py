# Problem2: Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
# Time Complexity: O(h), where h is the height of the tree.We move one level down the tree at each step of the loop, so the number of steps depends on the height. 
# Space Complexity: O(1), This is the iterative version, so we are just reassigning the root pointer as we move. 
# Approach:
# This is a BST, so left subtree values are always smaller than the node and right subtree values are always bigger. We use that property to decide which way to move at each node.
# If both p and q are smaller than the current node, the LCA must be in the left subtree, so we move left.
# If both are bigger, the LCA must be in the right subtree, so we move right.
# The moment they split (one smaller, one bigger) or one of them equals
# the current node, we have found the point where their paths diverge.
# That node is the LCA, so we return it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True:     # root here is our "current node" pointer, it moves as we walk down the tree

            if p.val < root.val and q.val < root.val:
                # both targets are smaller than current node, so LCA must be in left subtree
                root = root.left
            elif p.val > root.val and q.val > root.val:
                # both targets are bigger than current node, so LCA must be in right subtree
                root = root.right
            else:
                # paths have split here (one smaller, one bigger) or one target equals root
                # this means current node is the lowest node that has both as descendants
                return root
        