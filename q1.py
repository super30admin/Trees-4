# Time Complexity : O(n), Where n is number of elments in the Binary search Tree
# Space Complexity : O(h), Where h is height of the Binary search Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#Here basic solution is do inorder traversal, Because inorder traversal will always produce the increasing order 

class Solution:
    count=0#This variable is public 
    result=-1
    #Inorder Traversal of the binary search tree
    def inorder(self,root,k: int)->None:
        if(root==None):
            return
        self.inorder(root.left,k)
        #Processing at that node
        self.count+=1
        if(self.count==k):
            self.result=root.val
            return
        self.inorder(root.right,k)
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        #Edge Case
        if(root==None):
            return self.result
        
        self.inorder(root,k)
        return self.result
        