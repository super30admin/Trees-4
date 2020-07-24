"""
// Time Complexity : o(n)
// Space Complexity : o(h), recursive soln and o(1) for iterative
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base
        #logic
        #utilizing the property of BST
        if p.val == root.val or q.val == root.val or p.val < root.val and q.val > root.val or p.val > root.val and q.val < root.val: #if the numbers are present on the either side of the root, then thats the ancestor
                return root

        elif p.val < root.val and q.val < root.val: #if both values are lesser than the root, go to left subtree
            return self.lowestCommonAncestor(root.left,p,q)
                
        else:
            return self.lowestCommonAncestor(root.right,p,q)#if both values are greater than the root, go to left subtree        
        """
        ITERATIVE
        while root:
            if p.val == root.val or q.val == root.val or p.val < root.val and q.val > root.val or p.val > root.val and q.val < root.val:
                return root

            elif p.val < root.val and q.val < root.val:
                root = root.left
                
            else:
                root = root.right
            """
