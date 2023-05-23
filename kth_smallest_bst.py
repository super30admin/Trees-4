# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We get the kth smallest element by keeping a track of the number of elements we have visited in an 
inorder traversal. When we reach the kth element, we return the value of that node.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None: return -1
        self.answer = -1
        self.k = k
        self.inorder(root)
        return self.answer

    def inorder(self, root):
        if root == None or self.answer != -1: return
        self.inorder(root.left)
        self.k -= 1
        if self.k == 0: self.answer = root.val
        self.inorder(root.right)
