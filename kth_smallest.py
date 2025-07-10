# Time complexity: O(h + k)
# Space complexity: O(h)

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = None
        self.dfs(root, k)
        return self.result

    def dfs(self, root: Optional[TreeNode], k: int) -> None:
        if root is None or self.count >= k:
            return
        self.dfs(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        self.dfs(root.right, k)
