# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time O(N)
#Space O(1)
class Solution:
    
    def inorder(self, root, k):
        
        if not root:
            return
        
        self.inorder(root.left, k)
        self.count = self.count + 1
        if self.count == k:
            self.result = root.val
        
        self.inorder(root.right,k)
    
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.count = 0
        self.result = None
        
        self.inorder(root,k)
        return self.result
        
