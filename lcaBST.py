# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# TC - O(n)
# SC - O(n)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def findLCA(node):
            if p.val < node.val and q.val < node.val:
                return findLCA(node.left)
            elif p.val > node.val and q.val > node.val:
                return findLCA(node.right)
            else:

                return node

        return findLCA(root)
