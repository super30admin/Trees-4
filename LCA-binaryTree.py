#Time complexity: O(n)
#Space complexity: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def helper(root, p, q):

            if root == None or root == p or root == q:
                return root
            
            left = helper(root.left, p, q)
            right = helper(root.right, p, q)

            if left == None and right == None:
                return None
            elif left != None and right == None:
                return left
            elif right!= None and left == None:
                return right
            else:
                return root
        return helper(root, p, q)