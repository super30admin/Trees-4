# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity: O(h + k)
# Time Complexity: O(h + k)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        ans = []
        def dfs(node):
            if not node: return 

            dfs(node.left)
            if len(ans) < k:
                ans.append(node.val)
            dfs(node.right)

        dfs(root)

        return ans[-1]

