# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Approach 2
    # TC: O(n)
    # SC: O(h)
    # Here we use dfs and return the element when found
    # so if left and right both are null => not found
    # if left and right both are found => current root is the LCA
    # if one of them is found and the other is null =>
    # the 2nd one lies below the found one => the found one is the LCA
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if ((root is None) or (root is p) or (root is q)):
            return root

        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)

        if((left is None) and (right is None)):
            return None
        elif((left is None) and (right is not None)):
            return right
        elif((left is not None) and (right is None)):
            return left
        else:
            return root

    # Backtracking Solution
    # TC: O(n)
    # SC: O(n)
    # Here perform backtracking
    # we maintain a path for both the nodes and for the last element we make a duplicate entry
    # so that while iterating, the shorter one does not go out of bounds and throw and error
    # def __init__(self):
    #     self.pathP = list()
    #     self.pathQ = list()
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if root is None:
    #         return None

    #     self.dfs(root,p,q,[])

    #     for i in range(len(self.pathP)):
    #         if self.pathP[i]!=self.pathQ[i]:
    #             return self.pathP[i-1]

    #     return None

    # def dfs(self,root,p,q,path):
    #     #base Case
    #     if root is None:
    #         return
    #     #logic
    #     path.append(root)
    #     if root==p:
    #         self.pathP = path[:]
    #         # we add the root twice so as to avoid the case where one of the pointers
    #         # move out of bounds during final traversal
    #         self.pathP.append(root)
    #     if root==q:
    #         self.pathQ = path[:]
    #         self.pathQ.append(root)

    #     self.dfs(root.left,p,q,path)
    #     self.dfs(root.right,p,q,path)

    #     #backtrack
    #     path.pop()
