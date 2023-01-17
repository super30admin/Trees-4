#time complexity: O(n)
#space complexity: O(d) where d=max depth of tree
#ran on leetcode: Yes
#do an inorder traversal of BST. decrment k after visiting a node. return the value of a node when k==1. 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self,root):
        if(root==None):
            return -1
        ans1=self.inorder(root.left)
        if(ans1!=-1):
            return ans1
        
        if(self.k==1):
            return root.val
        self.k-=1    
        ans2=self.inorder(root.right)
        return ans2
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k=k
        return self.inorder(root)
