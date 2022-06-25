# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:      
        self.output=None
        self.n=k
        def helper(root):
            if not root:
                return
            helper(root.left)
            self.n-=1
            if self.n==0:
                self.output=root.val
                return
            helper(root.right)
            
        helper(root)
        return self.output