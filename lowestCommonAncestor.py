class Solution:
    # Time Complexity : o(N)
    # space Complexity : o(N)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.result = None

        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)

            curr = p == root or q == root

            if left + right + curr >= 2:
                self.result = root

            return curr or left or right

        dfs(root)
        # print(self.result)
        return self.result