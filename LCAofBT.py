'''
    Time Complexity:
        O(n) (where n = number of nodes)

    Space Complexity:
        O(h) (where h = height of the tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        DFS approach.
        -> If you find p, return root.
        -> If you find q, return root.
        -> Recurssive look for p and q in the left and right subtrees.
            -> If the both responses are not None, return root.
            -> Otherwise return the response that is not None.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if (left and right) or root == p or root == q:
            return root

        return left or right
