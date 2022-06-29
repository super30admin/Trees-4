'''
time complexity: O(n)
space complexity: o(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if(root==None or root == p or root==q): return root
        
        global list1,list2
        list1=[]
        list2=[]
        
        self.helper(root,p,q,[])

        for i in range(len(list1)):
            if(list1[i]!=list2[i]):
                return list1[i-1]
    def helper(self,root,p,q,ls):
        global list1,list2
        #base
        if(root==None): return
        #logic
        ls.append(root)
        if(root==p):
            list1 = list(ls)
            list1.append(p)
        if(root==q):
            list2 = list(ls)
            list2.append(q)
        
        #backtrack
        self.helper(root.left,p,q,ls)
        self.helper(root.right,p,q,ls)
        
        ls.pop()