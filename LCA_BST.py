#Time Complexity: O(H)

#Space Complexity: O(H) where H is the height of the tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.result =  TreeNode(None)
        if not root:
            return root
        
        
        def helper(node):
            if not node:
                return
            
            if (p.val < node.val) and (q.val < node.val):
                helper(node.left)
            elif (p.val > node.val) and (q.val > node.val):
                helper(node.right)
            else:
                self.result = node
                return
        helper(root)
        return self.result