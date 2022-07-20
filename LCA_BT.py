# Time Complexity : O(n)
# Space Complexity : O(1); considering recursive stack space - O(h).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Using Extra-space
# TC: O(n); SC: O(n) + O(n) --> O(n)
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def helper(self, root, p, q, path):
        # base
        if not root:
            return
        # logic
        path.append(root)
        if root == p:
            self.path_p = path[:]
        elif root == q:
            self.path_q = path[:]
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        path.pop()

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.path_p = []
        self.path_q = []
        self.helper(root, p, q, [])
        lca = None
        ptr = 0
        while ptr < len(self.path_p) and ptr < len(self.path_q):
            if self.path_p[ptr] == self.path_q[ptr]:
                lca = self.path_p[ptr]
                ptr += 1
            else:
                return lca
        return lca


root = TreeNode(3)
root.left = TreeNode(5)
root.right = TreeNode(1)
root.left.left = TreeNode(6)
root.left.right = TreeNode(2)
root.right.left = TreeNode(0)
root.right.right = TreeNode(8)
root.left.right.left = TreeNode(7)
root.left.right.right = TreeNode(4)
print(Solution().lowestCommonAncestor(root, root.left.right, root.left.right.right))
