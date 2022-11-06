# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree, worse case - O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


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
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root        