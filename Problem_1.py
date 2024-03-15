# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity - O(n). We traverse all nodes of the tree
Space Complexity - O(n), due to recursive stack space

Works on Leetcode
'''
class Solution:
    def __init__(self):
        self.count = 0
        self.result = None
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.dfs(root, k)
        return self.result.val
    
    def dfs(self, root, k): #inorder traversal
        if root == None:
            return 
        if self.count < k:
            self.dfs(root.left, k)
        self.count+=1 #increment count at every note we visit
        if self.count == k:
            self.result = root #assign the root to the result when counter reaches k 
        if self.count < k:
            self.dfs(root.right, k)
        
        