# Time Complexity : O(logh) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to insert delete in a bst in log time also find the kth smallest by maintaining left count.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res=TreeNode()
        self.c=k
        self.inorder(root)
        return self.res.val
    
    def inorder(self,root):
        if root == None:
            return 
        self.inorder(root.left)
        self.c-=1
        if(self.c==0):
            self.res=root
        self.inorder(root.right)
