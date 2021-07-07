# Runs on Leetcode
  n is the number of nodes in the BST
    # Solution 1
        # Runtime - O(n)
        # Memory - O(n)
        
    # Solution 2
        # Runtime - O(n)
        # Memory - O(n) considering the recursive stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Solution 1

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return 
        self.d = []
        self.inorder(root)
        return self.d[k-1]
        
    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        self.d.append(root.val)
        self.inorder(root.right)
        
# Solution 2

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return
        self.count = k
        self.a = 0
        self.helper(root)
        return self.a
    
    def helper(self, root):
        if root.left:
            self.helper(root.left)
            
        self.count -= 1
        if self.count == 0:
            self.a = root.val
            return
        
        if root.right:
            self.helper(root.right)
