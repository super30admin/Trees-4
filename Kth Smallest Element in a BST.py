# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n)
#SC: O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Basic Soln without follow up 
        self.result = 0
        self.count = k
        self.flag = False
        
        def helper(root):
            if not root:
                return
            if not self.flag:
                helper(root.left)
            
            self.count -= 1
            if self.count == 0:
                self.flag = True
                self.result = root.val
                return
            if not self.flag:
                helper(root.right)
                
        helper(root)
        return self.result