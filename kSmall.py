#Time complexity: O(n)
#Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.cnt = k
        self.res = 0
        
        self.helper(root)
        
        return self.res
    def helper(self, root):
        if root == None:
            return
        
        self.helper(root.left)
        self.cnt -= 1
        if self.cnt == 0:
            self.res = root.val
            return
        self.helper(root.right)
        
        
        
        
