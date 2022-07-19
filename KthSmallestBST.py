#230. Kth Smallest Element in a BST
"""
Time Complexity : O(n)
Space Complexity : O(height of k)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    count = 0
    result = 0
    flag = True
    def helper(self, root, k):
        #base
        if root == None:
            return 
        
        #logic
        self.helper(root.left, k)
        
        #print(k, root.val)
        self.count = self.count + 1
        if self.count == k and self.flag == True:
            self.result = root.val
            self.flag = False
        
        self.helper(root.right, k)
        
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = 0
        self.flag = True
        self.helper(root, k)
        return self.result
