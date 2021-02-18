# Time Complexity : O(n)
# Space Complexity : O(n) considering stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I do inorder traversal and whenever I find p or q I return it up the tree. Whenever I get both non null elements from both left and right I assign current root
# as elements

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.parent = None
        def backtrack(root, p, q):
            if not root:
                return None
            
            if self.parent:
                return 
            
            
            l = backtrack(root.left, p, q)
            
            r = backtrack(root.right, p, q)
            
            if l and r:
                self.parent = root
                return
            
            if root == p or root == q:
                if l or r:
                    self.parent = root
                return root
            
            return l or r
        
        backtrack(root, p, q)
        return self.parent
