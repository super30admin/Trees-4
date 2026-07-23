# Problem3: Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
# Time Complexity: O(n), In the worst case we visit every node once, since we don't have any ordering property, We have to search both left and right subtrees fully to know if p and q are there.
# Space Complexity: O(h), where h is the height of the tree.
# Approach:
# For each node, we recursively search its left and right subtrees for p and q. There are four possible outcomes:
# 1. Neither side finds anything, so we return None upward.
# 2. Only the left side finds something, so we pass that value up unchanged,since both targets must live in the left subtree.
# 3. Only the right side finds something, mirrored case.
# 4. Both sides find something, meaning p and q's paths split at this exact node, so this node is the LCA.
# The base case handles landing directly on p, q or running off the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root

        # ask left and right subtrees whether they contain p or q
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None:      # neither subtree found p or q, nothing to report upward
            return None

        elif left is not None and right is None:    # only left subtree found something, so LCA must be entirely in left subtree
            return left

        elif left is None and right is not None:    # only right subtree found something, so LCA must be entirely in right subtree
            return right

        else:       # both sides found something, meaning p and q split apart at this node so this node is the lowest common ancestor
            return root