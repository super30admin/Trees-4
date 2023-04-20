# TC : O(N)
# SC : O(N)
import heapq
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        minHeap = []
        def dfs(root):
            if not root:
                return
            heapq.heappush(minHeap,root.val)
            dfs(root.left)
            dfs(root.right) 
        
        dfs(root)
        elem = root.val
        while k > 0:
            elem = heapq.heappop(minHeap)
            k -= 1

        return elem


