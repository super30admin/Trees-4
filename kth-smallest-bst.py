# time: O(n) where k = n
# space O(h) height of tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# recursive solution
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = None
        self.helper(root,k)
        return self.result.val
    def helper(self,root,k):
        if root is None:
            return 
        if self.result is None:
            self.helper(root.left,k)
        self.count+=1
        if self.count == k:
            self.result = root
        if self.result is None:
            self.helper(root.right,k)
        

# stack solution
# O(n) time
# space O(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        res = []

        while stack or root:
            while root:
                stack.append(root)
                root = root.left 
            root = stack.pop()
            res.append(root)
            root = root.right 
        
        return res[k-1].val