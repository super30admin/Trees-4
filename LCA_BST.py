# Time Complexity : O(n)
# Space Complexity : O(1); considering recursive stack space - O(h).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# recursive
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > q.val:
            return self.lowestCommonAncestor(root, q, p)
        if (p.val < root.val and q.val > root.val) or p.val == root.val or q.val == root.val:
            return root
        elif p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)


root = TreeNode(6)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.left = TreeNode(0)
root.left.right = TreeNode(4)
root.right.left = TreeNode(7)
root.right.right = TreeNode(9)
root.left.right.left = TreeNode(3)
root.left.right.right = TreeNode(5)
print(Solution().lowestCommonAncestor(root, root.left.right, root.left.right.right))


# iterative
# TC: O(n); SC: O(1)
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#
#
# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         while root:
#             if p.val > q.val:
#                 return self.lowestCommonAncestor(root, q, p)
#             if (p.val < root.val and q.val > root.val) or p.val == root.val or q.val == root.val:
#                 return root
#             elif p.val < root.val and q.val < root.val:
#                 root = root.left
#             elif p.val > root.val and q.val > root.val:
#                 root = root.right
#
#
# root = TreeNode(6)
# root.left = TreeNode(2)
# root.right = TreeNode(8)
# root.left.left = TreeNode(0)
# root.left.right = TreeNode(4)
# root.right.left = TreeNode(7)
# root.right.right = TreeNode(9)
# root.left.right.left = TreeNode(3)
# root.left.right.right = TreeNode(5)
# print(Solution().lowestCommonAncestor(root, root.left.right, root.left.right.right))
