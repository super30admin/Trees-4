# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathp = []
        self.pathq = []
        self.flagp = self.flagq = False
        if not root:
            return None
        
        # call the backtrack which is the helper solution 
        self.backtrack(root, p, q, [])
        
        # after forming the two paths for p and q, check for the common one, which is our result
        for i in range(len(self.pathp)):
            if self.pathp[i] != self.pathq[i]:
                return self.pathp[i-1]
        
    def backtrack(self, root, p, q, path):
        if not root:
            return
        # action
        # append the node to the path
        path.append(root)
        
        # if we find the p node, add the path till now to the pathp and add the current node once more to take care of the result comparison
        # also set the flag as true
        if p == root:
            self.pathp = (path[:])
            self.pathp.append(root)
            self.flagp = True
        # if we find the q node, add the path till now to the pathq and add the current node once more to take care of the result comparison
        # also set the flag as true
        if q == root:
            self.pathq = (path[:])
            self.pathq.append(root)
            self.flagq = True
        # recurse
        # only recurse if either flags is true
        if not self.flagp or not self.flagq:
            self.backtrack(root.left, p, q, path)
        if not self.flagp or not self.flagq:
            self.backtrack(root.right, p, q, path)
        
        # backtrack
        # remove the last added element to the path to maintain just one single list of path
        path.pop()
