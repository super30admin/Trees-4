#Time Complexity O(N) + O(NlogN)
#Space Complexity O(N)

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res = []
        
        def dfs(root):
            if root:
                dfs(root.left)
                self.res.append(root.val)
                dfs(root.right)
        dfs(root)
        self.res.sort()
        return self.res[k-1]
        
