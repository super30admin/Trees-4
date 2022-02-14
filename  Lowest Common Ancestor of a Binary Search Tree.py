# Time Complexity :
# TC: O(logN)
    
# Space Complexity :
# SC: O(H) --> size of stack --> height of tree

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
    
    # Iterative
    # TC: O(logN) 
    # SC: O(H) --> size of stack --> height of tree
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        while (True):
            if (root.val > p.val and root.val > q.val): root = root.left
            elif (root.val < p.val and root.val < q.val): root = root.right
            else: return root