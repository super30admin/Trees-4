# Time Complexity : O(k)
# Space Complexity : O(h); considering recursive stack space - O(h).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# iterative.
# TC: O(k); SC: O(h)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthSmallest(self, root, k: int) -> int:
        self.stack = []
        count = 0
        while self.stack or root:
            while root:
                self.stack.append(root)
                root = root.left
            pop = self.stack.pop()
            count += 1
            if count == k:
                return pop.val
            if count < k:
                root = pop.right


root = TreeNode(6)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.left = TreeNode(0)
root.left.right = TreeNode(4)
root.right.left = TreeNode(7)
root.right.right = TreeNode(9)
root.left.right.left = TreeNode(3)
root.left.right.right = TreeNode(5)
print(Solution().kthSmallest(root, 4))


# recursive.
# TC: O(k); SC: O(h), assuming recursive stack space O(k)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def helper(self, root, k):
#         # base
#         if root is None:
#             return
#         # logic
#         self.helper(root.left, k)
#         self.count += 1
#         if self.count == k:
#             self.result = root.val
#             return
#         if self.count < k:
#             self.helper(root.right, k)
#
#     def kthSmallest(self, root, k: int) -> int:
#         self.count = 0
#         self.result = 0
#         self.helper(root, k)
#         return self.result
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
# print(Solution().kthSmallest(root, 4))
