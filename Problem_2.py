"""
Problem : 1

Time Complexity : O(h) //h=hright of the tree
Space Complexity : O(h)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Lowest Common Ancestor of a Binary Search Tree

# Approach - 1
# Backtracking

class Solution(object):
    def __init__(self):
        self.pathP=[]
        self.pathQ=[]
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return root
        
        self.backtrack(root,p,q,[])

        for i in range(len(self.pathP)):
            if self.pathP[i]!=self.pathQ[i]:
                return self.pathP[i-1]
        return None
    
    def backtrack(self,root,p,q,path):
        # base
        if not root:
            return
        # logic
        # action
        path.append(root)
        if root==p:
            self.pathP=path[::]
            self.pathP.append(p)
        if root==q:
            self.pathQ=path[::]
            self.pathQ.append(q)
        
        # recurse
        if len(self.pathP)==0 or len(self.pathQ)==0:
            self.backtrack(root.left,p,q,path)
        if len(self.pathP)==0 or len(self.pathQ)==0:
            self.backtrack(root.right,p,q,path)
        # recurse
        path.pop()



# Approach - 2
# Recursion

class Solution(object):

    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root or root==p or root==q:
            return root
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        if not left and not right:
            return None
        elif left and not right:
            return left
        elif right and not left:
            return right
        else:
            return root

