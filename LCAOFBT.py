"""
//Time Complexity : O(N)
// Space Complexity :O(Height)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""


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
        #T.C = O(n)
        #S.C = O(Height of Tree)
        if root == None:
            return root
        self.path1 = list()
        self.path2 = list()
        
        self.backtrack(root,p,q,[])
        
        for i in range(0,len(self.path1)):
            if self.path1[i] != self.path2[i]:
                return self.path1[i-1]
        return None
    def backtrack(self,root,p,q,path):
        #base
        if root is None:
            return 
        if root == q:
            self.path1 = list(path)
            self.path1.append(q)
            self.path1.append(q)
        if root == p:
            self.path2 = list(path)
            self.path2.append(p)
            self.path2.append(p)
            
        
        #logic
        
        path.append(root)
        
        self.backtrack(root.left,p,q,path)
        self.backtrack(root.right,p,q,path)
        path.pop()
        
