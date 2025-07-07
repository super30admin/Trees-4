# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Time complexity - o(h)
# Space complexity - o(h)

# Intuition - 
# Traverse the tree recursively and return the node if it matches p, q, or is None.
# Let the left and right subtrees search for p and q.
# The first node where both left and right return non-null is the lowest common ancestor.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        

        def helper(node):

            if node is None or node.val == p.val or node.val == q.val:
                return node

            left = helper(node.left)
            right = helper(node.right)

            if left is None and right is None:
                return None

            elif left is None and right is not None:
                return right

            elif left is not None and right is None:
                return left

            else:
                return node

        return helper(root)