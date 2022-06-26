# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # self.path1 = None
        # self.path2=None
        # self.helper(root,p,q,[root])
        # prev = None
        # ptr1=0
        # ptr2= 0
        # for i in range (min(len(self.path1),len(self.path2))):
        #     if(self.path1[i]!=self.path2[i]):
        #         break
        #     prev = self.path1[i]
        # return prev
        if(root==None or root.val==p.val or root.val==q.val):
            return root
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        if(left==None and right==None):
            return None
        elif(left!=None and right==None):
            return left
        elif(right!=None and left==None):
            return right
        else:
            return root
    def helper(self,root,p,q,curr):
        if(root==None or (self.path1!=None and self.path2!=None)):
            return 
        
        if(root.val == p.val):

            self.path1 = curr.copy()
            
        if(root.val==q.val):
            self.path2 = curr.copy()
        curr.append(root.left)
        self.helper(root.left,p,q,curr)
        curr.pop(-1)
        curr.append(root.right)
        self.helper(root.right,p,q,curr)
        curr.pop(-1)
        
            