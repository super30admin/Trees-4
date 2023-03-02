# time Complexity: O(N)
# space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return root
        if (p.val <= root.val and q.val >= root.val) or (q.val <= root.val and p.val >= root.val):
            return root
        elif p.val <= root.val and q.val <= root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val >= root.val and q.val >= root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        # return root
