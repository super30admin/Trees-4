#Time Complexity :O(h+k)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count=k
        self.result=None
        self.helper(root)
        return self.result.val

    def helper(self,root):
        if not root:
            return 
            
        if self.count>0: 
            self.helper(root.left)
        
        self.count-=1
        if self.count==0:
            self.result=root

        if self.count>0: 
            self.helper(root.right)
