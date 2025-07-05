# // Time Complexity : 1) o(h) o
# // Space Complexity :(h) optimized space iterative solution
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : idea of using bst property


# // Your code here along with comments explaining your approach
# 1) we can use the bst property of root being greater than left and right so if the root is greater than we have lca otherwise we move left or right 
# 2) we can optimize the space by using the while loop and doing it iteratively
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if not root : return None
#         if root.val > p.val and root.val > q.val:
#             return self.lowestCommonAncestor(root.left,p,q)
#         elif root.val<p.val and root.val<q.val:
#             return self.lowestCommonAncestor(root.right,p,q)
#         else:
#             return root

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root : return None
        while root:
            if root.val > p.val and root.val>q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root
        
