# recursive - TC - O(h)
# SC - O(h) -- recursive stack space


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.ans = None

        def recurse(curr_node):
            if not curr_node:
                return False

            # recurse left branch
            left = recurse(curr_node.left)

            # recurse right branch
            right = recurse(curr_node.right)

            # if either of p or q is ancestor then assign it to mid
            mid = curr_node == p or curr_node == q

            if mid + left + right >= 2:
                self.ans = curr_node

            # return true if left or right or mid are true
            return mid or left or right

        recurse(root)
        return self.ans