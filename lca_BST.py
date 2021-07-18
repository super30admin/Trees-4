# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def lowestCommonAncestor(self, root, p, q):
        # we will check if given p and q lies on left side if then we will shift root
        # to left or else right , if not both we will return root
        while (True):
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root


