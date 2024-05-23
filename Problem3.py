## Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

# Approach
# Append root to path. If root == p set pathP = path[:] and append root. Similarly, If root == q, set pathQ = path[:] and append root.
# Recursively call dfs function with root.left and root.right
# Backtrack at each step and pop the last element from the path. Traverse through pathP and pathQ. Return the element prior to unmatching element


# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def dfs(self,root,p,q,path):
        # base
        if root == None:
            return

        #logic
        path.append(root)
    

        if root == p:
            self.pathP = path[:]
            self.pathP.append(root)


        if root == q:
            self.pathQ = path[:]
            self.pathQ.append(root)

     
        self.dfs(root.left,p,q,path)

        
        self.dfs(root.right,p,q,path)
        
        #backtrack
        path.pop()


    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathP = []
        self.pathQ = []
        self.dfs(root,p,q,[])

        
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]