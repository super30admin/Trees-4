# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # store the value of k as count which is global
        self.count = k
        if not root:
            return 0
        self.res = 0
        # call the helper function recursively
        self.helper(root)
        return self.res
    
    def helper(self, root):
       # if not root, then return to the previously called function
        if not root:
            return
        
        # call the root.left
        self.helper(root.left)
        
        # decrement the count which was k
        self.count -= 1
        
        # check if k ==0, if so, then put res as root.val
        if self.count == 0:
            self.res = root.val
            
          # check for root.right
        self.helper(root.right)
