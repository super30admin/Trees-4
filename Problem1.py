# Time Complexity : O(k)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#inorder traversal and stopping when the count reaches k
class Solution:
    
    def __init__(self):
        self.result = None
        self.count = 0
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.inorder(root,k)
        return self.result
    
    def inorder(self,root,k):
        if root != None:
            self.inorder(root.left,k)
            self.count += 1
            if self.count == k:
                self.result = root.val
                return root.val
            self.inorder(root.right,k)
        
        