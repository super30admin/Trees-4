# Definition for a binary tree node.

# class TreeNode:

#     def __init__(self, x):

#         self.val = x

#         self.left = None

#         self.right = None



class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':



        # taking advantage of the BST property that left side of node is smaller and right is larger

        while root:

            if root.val > p.val and root.val > q.val:

                root = root.left

            elif root.val < p.val and root.val < q.val:

                root = root.right

            elif root.val == p.val or root.val == q.val:

                return root

            else:

                return root
