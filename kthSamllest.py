# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(n)
#Space Complexity :O(1)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.output = 0
        self.res = 0
        self.helper(root, k)
        return self.res
    
    def helper(self, root, k):
        if(root == None):
            return
        self.helper(root.left, k)
        self.output += 1
        if(self.output == k):
            self.res = root.val
        self.helper(root.right, k)
