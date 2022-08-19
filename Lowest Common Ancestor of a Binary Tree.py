# Time complexity: O(n)
# Space complexity: O(h)
# Approach: Do bottom up recursion
# go to the left and right bottom and pass the values to its parent.
# passing values to parent: if u find a p or q value, return p or q, if you reach null, return null
# Now, you will have something returned from bottom return it to its parent and pass it on.
# do this value passing using recursion by recursing left and right



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root== p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left == None and right == None:
            return None
        elif left != None and right == None:
            return left
            
            
        elif left == None and right != None:
            return right
        else:
            return root
        
        