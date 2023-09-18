# Time Complexity :O(K)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    c=0
    ans=None
    def helper(self, root, k):
        if(root==None):
            return
        
        if(self.ans==None):
            self.helper(root.left, k)
            self.c+=1
            if(self.c==k):
                self.ans=root
                return
            # if(self.ans==None):
            self.helper(root.right, k)
        return None

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root, k)
        return self.ans.val