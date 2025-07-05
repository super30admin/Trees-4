# // Time Complexity : path finding o(n) 
# // Space Complexity : o(h) h -can be logn in perfect tree or o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : backtracking to store path


# // Your code here along with comments explaining your approach
# idea is to store the paths of p and q (using backtrack or deepcopy) and then compare where it does'nt match that the first node is the lca
# we can use bottom up recursion to get lca as well we can return left or right once one of them is null

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         self.pathp = []
#         self.pathq = []
#         def helper(root, p, q, path):
#             # base
#             if not root : return
#             # if not self.pathp and not self.pathq : return 
#             # logic
#             # action
#             path.append(root)
#             if root == p:
#                 self.pathp = path[:]
#                 self.pathp.append(root)
#             if root == q:
#                 self.pathq = path[:]
#                 self.pathq.append(root)
#             # recurse
#             helper(root.left, p,q,path)
#             helper(root.right, p,q, path)
#             # backtrack
#             path.pop()
#         helper(root, p, q, [])
#         for i in range(len(self.pathp)):
#             if self.pathp[i] != self.pathq[i]:
#                 return self.pathp[i-1]
#         return None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p,q)
        right = self.lowestCommonAncestor(root.right, p,q)
        if not left and not right: return None
        elif not left and right: return right
        elif not right and left: return left
        else: return root
        