# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time Complexity: O(N)

#Space Complexity: O(H) where H is the height of the tree
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
 
        if not root:
            return root
        
        def backtrackpath(node):
            if not node or node == p or node == q:
                return node
            
            #logic
            left = backtrackpath(node.left)
            right = backtrackpath(node.right)
            
            if left and right:
                return node
            elif not left and right:
                return right
            elif not right and left:
                return left
            else:
                return left

        return backtrackpath(root)
