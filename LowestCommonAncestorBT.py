#// Time Complexity : O(n) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : yes, in the second code i was using deepcopy insted of copy and it was giving me error.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if root == None or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)

        if left != None and right != None:
            return root
        elif left == None and right != None:
            return right
        elif left != None and right == None:
            return left
        else:
            return None

        # pathP = []
        # pathQ = []


        # def helper(node,path,p,q):
        #     nonlocal pathP
        #     nonlocal pathQ
        #     if node == None:
        #         return
        #     path.append(node)
        #     if node==p:
        #         pathP=path.copy()
        #         pathP.append(p)
        #     if node==q:
        #         pathQ=path.copy()
        #         pathQ.append(q)
        
        #     helper(node.left,path,p,q)
        #     helper(node.right,path,p,q)
        #     path.pop()
        
        # helper(root,[],p,q)
        # # print(pathQ)

        # for i in range(len(pathP)):
        #     if pathP[i] != pathQ[i]:
        #         return pathP[i-1]

        # return None

        
# Approach:
# The problem can be solved using a recursive approach. We start by checking if the root is None or
# if the root is equal to either p or q. If it is, we return the root.
# If the root is not None and not equal to p or q, we recursively call the function on
# the left and right subtrees. If both left and right subtrees return a value, it means
# that p and q are in different subtrees, so we return the root. If only one of
# them returns a value, we return that value. If neither of them returns a value, it means
# that p and q are not in the tree, so we return None.
