# // Time Complexity :O(n)
# // Space Complexity :O(height)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we keep path from root to p and q in two separte lists and take the value that matches in both lists just before the mismatch happens
class Solution(object):
    # pathp=[]
    # pathq=[]
    # def backtrack(self,root,p,q,path):
    #     # base
    #     if(root is None):
    #         return
    #     path.append(root)
    #     if(root==p):
    #         self.pathp=list(path)
    #         self.pathp.append(p)
    #     if(root==q):
    #         self.pathq=list(path)
    #         self.pathq.append(q)
    #     # logic
    #     # action
        
    #     self.backtrack(root.left,p,q,path)
    #     self.backtrack(root.right,p,q,path)
    #     path.pop()
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        
        # if not root:
        #     return None
        # self.backtrack(root,p,q, [])
        # m=len(self.pathp)
        # if(len(self.pathq)<m):
        #     m=len(self.pathq)
        # for i in range(m):
        #     if(self.pathp[i] != self.pathq[i]):
        #         return self.pathp[i-1]
        # return None

        # optimized
        if(root is None or root==p or root==q):
            return root
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        if(left is None and right is None):
            return None
        elif(left is not None and right is None):
            return left
        elif(left is None and right is not None):
            return right
        else:
            return root


        