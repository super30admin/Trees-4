# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
            https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
            Time Complexity - O(n)
            Space Complexity - O(h)
            'h' height of tree
            'n' is the number of nodes in tree
        """
        # base case
        if not root: return None

        # we have found either nodes, root itself is the common desecendent
        if root.val == p.val or root.val == q.val: return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # root is the LCA (because we found both p and q)
        if left is not None and right is not None: return root

        # neither of the nodes were found in the left and right subtrees
        if left is None and right is None: return None

        # return node which is not None, one of them will be None
        if left is not None:
            return left
        else:
            return right
