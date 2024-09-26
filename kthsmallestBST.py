"""
Time Complexity: O(N)
Space Complexity: O(1)
Compiled on leetcode? Yes
"""
class Solution:
    def __init__(self):
        self.result = None
        self.k = None
        
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.k = k
        self.inorder(root)
        return self.result
        
        
    def inorder(self, root):
        if root is None:
            return
        self.inorder(root.left)
        self.k = self.k - 1
        if self.k == 0:
            self.result = root.val
            return
        self.inorder(root.right)