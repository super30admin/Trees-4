# TC: O(N)
# SC: O(1)
# Yes, It ran on leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root, k):
        self.k = k
        self.res = 0
        
        def helper(root):
            if root:
                helper(root.left)           # go till leftmost node and then do subtracting k till 0
                self.k -= 1
                if self.k == 0:
                    self.res = root.val
                    return 
                helper(root.right)
        
        helper(root)
        return self.res

    