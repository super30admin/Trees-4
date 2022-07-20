# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root==None: return None
        self.result=None
        self.count=k
        self.dfs(root,k)
        return self.result
    def dfs(self, root: Optional[TreeNode], k: int):
        if root==None: return
        self.dfs(root.left,k)
        self.count-=1
        if self.count==0:
            self.result=root.val
        self.dfs(root.right,k)
    # def dfs(self, root: Optional[TreeNode], k: int):
    #     if root==None: return float('inf')
    #     left=self.dfs(root.left,k)
    #     if left!=float('inf'): return left
    #     self.count-=1
    #     if self.count==0:
    #         return root.val
    #     return self.dfs(root.right,k)        
        