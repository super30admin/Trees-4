'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        global res
        self.cnt = k
        self.helper(root)
        return res
        
    def helper(self,root):
        global res
        if root==None: return
        
        self.helper(root.left)
        self.cnt-=1
        if(self.cnt==0):
            res = root.val
            return 
        self.helper(root.right)
        