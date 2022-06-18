# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time complexity: O(n)
#Space complexity: O(h)
class Solution:
    def kthSmallest(self, root, k: int) -> int:
        self.count=k
        self.ele=-1
        self.helper(root)
        return self.ele
    def helper(self,curr):
        if not curr:
            return
        self.helper(curr.left)
        self.count-=1
        if self.count==0:
            self.ele=curr.val
        self.helper(curr.right)
        