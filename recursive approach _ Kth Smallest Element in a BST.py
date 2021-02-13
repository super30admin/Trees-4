#time: O(n)
#space:O(h)

#recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=-1
    count=0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if(root==None):
            return -1
        self.count=0
        self.helper(root,k)
        return self.result
    def helper(self,root,k):
        if(root==None):
            return 
        self.helper(root.left,k)
        self.count+=1
        if(self.count==k):
            self.result=root.val
            return
        self.helper(root.right,k)
    