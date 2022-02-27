# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        res = 0
        
        def dfs(node, step):
            nonlocal res
            if node:                
                step = 1 + dfs(node.left, step)
                
                if step == k:
                    res = node.val
                
                step = dfs(node.right, step)

            return step
            
        dfs(root, 0)
        return res