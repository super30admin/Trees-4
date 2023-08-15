# Time Complexity: O(h)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        while True:
            if (root.val > p.val) and (root.val > q.val):
                root = root.left
            elif (root.val < p.val) and (root.val < q.val):
                root = root.right
            else:
                return root