# Definition for a binary tree node.
# class TreeNode:
    # def __init__(self, val=0, left=None, right=None):
    #     self.val = val
    #     self.left = left
    #     self.right = right
    #     self.countleft=0
class Solution:
    """Recursive approach
    Time complexity-O(n)
    Space complexity-O(1)"""
    def __init__(self):
        self.count=0
        self.result=-1
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.helper(root, k)
        return self.result
    
    def helper(self, root, k):
        if not root:
            return None
        if self.result==-1:
            self.helper(root.left, k)
        self.count+=1
        if self.count==k:
            self.result= root.val
        if self.result==-1:
            self.helper(root.right, k)
        
        
        
        