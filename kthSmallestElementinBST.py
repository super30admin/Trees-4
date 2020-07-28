-------------------------------- kth smallest element in BST ---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I will iterate through the tree inorder and reduce my k for each left recursion. Once I reach k == 0, 
#then I will update my res variable with that root.val. At last return the result.


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return 0
        
        def dfs(root):
            if not root:
                return
            
            dfs(root.left)
            self.key -=1
            if self.key == 0:
                self.res = root.val
            dfs(root.right)
    
        self.res = 0
        self.key = k
        dfs(root)
        return self.res