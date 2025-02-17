# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return -1
        self.counter = 0
        self.result = -1
        self.dfs(root, k)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], k: int ) -> None:
        if root == None or self.result != -1:
            return 
        self.dfs(root.left,k)
        self.counter +=1
        if self.counter == k:
            self.result = root.val
            return 
        self.dfs(root.right , k)


        
        