# TimeComplexity O(N)
# SpaceComplexity :O(h)
# Approach : we canfind both paths and based on that we can find lca. but do we need paths or do we need to extra work if both p and q are in same sub tree
# 1.both are in left sub tree: if we encounter p first then p else q same with if both are in right 
# 2. both are in differnt sub trees
#         for each node we will have left and right nodes if its has p/q in left then left will have p or else null same with q
#         after finding left and right we check if left and right are none are have any values b.based onthat we return LCA






# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def helper(root, p,q):
            #base what things are chaging/approch end
            if root==None or root==p or root==q:
                return root



            #logic
            left=helper(root.left,p,q)
            right=helper(root.right,p,q)
            if left==None and right ==None:return None
            elif left!=None and right==None:return left
            elif left==None and right!=None: return right
            else :return root
        return  helper(root, p,q)
