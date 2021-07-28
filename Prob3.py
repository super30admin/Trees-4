# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #bottom up recursion
         #time : O(n)
            #space: O(h)
        def lca(root,p,q):
            #base
            if root is None or root is p or root is q:
                return root
            #logic
            left = lca(root.left,p,q)
            right = lca(root.right,p,q)
            # if both not none, we've found the parent
            if left is not None and right is not None:
                return root
            # if one is not none, then broadcast that above, else broadcast none above
            elif left is not None:
                return left
            elif right is not None:
                return right
            else:
                return None
        return lca(root,p,q)
        # backtracking
#         #time : O(n)
#         #space: O(h)
#         self.path1 = []
#         self.path2 = []
        
#         def backtrack(root,p,q,path):
#             #base
#             if root is None:
#                 return
#             if root == p:
#                 self.path1 = [x for x in path]
#                 self.path1.append(root)
#                 self.path1.append(root)
#             if root == q:
#                 self.path2 = [x for x in path]
#                 self.path2.append(root)
#                 self.path2.append(root)
#             #logic
#             #action
#             path.append(root)
#             #recurse
#             if not self.path1 or not self.path2:
#                 backtrack(root.left,p,q,path)
#             if not self.path1 or not self.path2:
#                 backtrack(root.right,p,q,path)
#             #backtrack
#             path.pop()
            
#         backtrack(root,p,q,[])
#         for i in xrange(len(self.path1)):
#             if self.path1[i] != self.path2[i]:
#                 res = self.path1[i-1]
#                 break
#         return res
