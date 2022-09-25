# Time Complexity : O(N) whenre N is number of Nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.k = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        
        return self.findKthSmallest(root)
        
    def findKthSmallest(self, root):
        if root == None:
            return 0

        left = self.findKthSmallest(root.left)
        self.k -= 1
        if self.k == 0:
            return  root.val
        right = self.findKthSmallest(root.right)
        
        return left + right