# Time Complexity:- O(n)
# Space Complexity:- O(n)
# Approach:- Simulataneously calculate the path to p and q node via backtracking. Always remember how dfs works while 
# recursion it explores both the left and right children before backtracking. That is exactly how we will calculate the path to the p and q nodes via backtracking. After we have found both the path, we will go through both the path
# at the first point where their paths differ is the last common ancestor of both the nodes. 
# # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathtop=[]
        self.pathtoq=[]
        res=""
        def pathtonode(root,path,p,q):
            if root is None:
                return
            path.append(root)
            if root==p:
                self.pathtop=path.copy()
            if root==q:
                self.pathtoq=path.copy()
            pathtonode(root.left,path,p,q)
            pathtonode(root.right,path,p,q)
            # IMP:- both the left and right children have been explored now backtrack
            path.pop()
        pathtonode(root,[],p,q)
        i=0
        while(i<len(self.pathtop) and i<len(self.pathtoq)):
            if self.pathtop[i]==self.pathtoq[i]:
                res=self.pathtop[i]
            else:
                # we are getting a different node on the path, the earlier node was the last common ancestor
                return res
            i+=1
        return res