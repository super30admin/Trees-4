# Time Complexity :
# TC: O(N) --> 1N --> Traversing the tree
    
# Space Complexity :
# SC: O(1)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    # Bottom Up Recursion
    # TC: O(N) --> 1N --> Traversing the tree
    # SC: O(1)
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        result = self.helper(root, p, q)
        
        return result
    
    def helper(self, root, p, q):
        
        # Base Case
        if (root == None or root == p or root == q): return root
        
        # Logic
        left = self.helper(root.left, p, q)
        right = self.helper(root.right, p, q)
        if (left == None and right == None): return None
        elif (left != None and right == None): return left
        elif (left == None and right != None): return right
        else: return root   