# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# TC - O(n)
# SC - O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def lcaRecursive(node):
            if node is None or node == p or node == q:
                return node
            left = lcaRecursive(node.left)
            right = lcaRecursive(node.right)

            if not left and not right:
                return None
            elif right and not left:
                return right
            elif left and not right:
                return left
            else:
                return node
        return lcaRecursive(root)
