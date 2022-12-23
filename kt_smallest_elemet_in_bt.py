# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:

        ## approach 2: iterative solution
        ## T.C = O(n)
        ## S.C = O(h)
        
        stack = []
        ctr = 0

        while stack or root:
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop(-1)
            ctr += 1
            if ctr == k:
                return root.val
            
            root = root.right



        ## approach 1: recursive solution
        ## T.C = O(n)
        ## S.C = O(h)

        res = [-1, -1]
        def dfs(root, k):
            if not root:
                return
            
            if res[-1] == -1:
                dfs(root.left, k)

            res[0] += 1
            if res[0] == k - 1:
                res[-1] = root.val
                return

            if res[-1] == -1:
                dfs(root.right, k)
        
        dfs(root, k)
        return res[-1]


        