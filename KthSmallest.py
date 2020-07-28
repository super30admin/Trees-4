# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.count=0
        self.result=0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.count=k
        self.inorder(root)
        return self.result
    
    def inorder(self,root):
        if root==None:
            return
        
        self.inorder(root.left)
        
        self.count-=1
        
        if self.count==0:
            self.result=root.val
            return
        self.inorder(root.right)
        
#Time comlexity is O(n)
#Space Complexity is O(h)
