'''
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        return root.val

    # def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    #     count = k
    #     res = root.val
    #     def inorder(root):
    #         nonlocal count, res
    #         if not root: return
    #         inorder(root.left)
    #         count -= 1
    #         if count == 0:
    #             res = root.val
    #         inorder(root.right)
    #     inorder(root)
    #     return res