## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

# Approach
# Inorder traversal will be sorted in BST. Keep a counter and res, initially set to None. 
# Perform conditional recursion, call the dfs function with root.left. Increment counter by 1. If counter == k, set res = root.val
# Continue recursion with root.left and root.right if self.res == None. return res

# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def dfs(self,root,k):
        
        # base
        if root == None:
            return

        #logic
        if self.res == None:
            self.dfs(root.left,k)

        self.counter += 1
        if self.counter == k:
            self.res = root.val
            return
        
        if self.res == None:
            self.dfs(root.right,k)

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res = None
        self.counter = 0
        self.dfs(root,k)
        return self.res