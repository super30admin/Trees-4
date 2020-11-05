"""
Author: Srinidhi
Time Complexity: O(N)
Space Complexity - O(N)

Logic: First find the nodes and when you find both, backtrack and find their parent
the condition is such that for a given node, both the left and right recursive calls should give  True
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':    
        def lowestCommonAncestorHelper(curr_node):
            if curr_node is None:
                return False
            
            left = lowestCommonAncestorHelper(curr_node.left)
            right = lowestCommonAncestorHelper(curr_node.right)
            curr = curr_node == p or curr_node == q
            
            if left + right + curr >= 2:
                self.ans = curr_node
            return left or right or curr
        
        lowestCommonAncestorHelper(root)
        return self.ans