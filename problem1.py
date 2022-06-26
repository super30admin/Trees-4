# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.ctr = 1
        self.ans = None
        self.helper(root,k)
        return self.ans
        
    def helper(self,root,k):
        if(root==None or self.ans!=None):
            return
        
        self.helper(root.left,k)
        if(self.ctr==k):
            self.ans = root.val
        self.ctr+=1
        self.helper(root.right,k)