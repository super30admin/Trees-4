# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def recurse(cur):
            if not cur:
                return False
            left = recurse(cur.left)
            right = recurse(cur.right)

            mid = cur == p or cur == q
            if mid + left + right >= 2:
                self.ans = cur

            return mid or left or right

        recurse(root)
        return self.ans
