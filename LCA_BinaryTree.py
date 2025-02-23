# Time Complexity : O(n) - dfs on the entire tree 
# Space Complexity : O(h), recursive stack space and the path lists ( O(3h) )
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# a node is allowed to be an ancestor of itself
# given two nodes - p and q
# only a binary tree, every node will have both left and right children
# need to keep a track of the path to p and q, we will do dfs on the tree to find p and q
# maintain the path lists for both p and q nodes - using backtracking
# the common elements in both lists are the common ancestors
# we need to find the closest same elements - lowest common ancestor
# first mismatched - 1
# if one list is smaller than the other, we insert the last node (p or q twice)
# this will lead to a mismatch
# the node prior to the different nodes in two lists is the answer LCA


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.pathP = [None]
        self.pathQ = [None]
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return root
        
        # using same recursive call for p and q both
        self.dfs(root, p, q, [])
        # we have the path to P in pathP
        # and the path to q in pathQ
        # traverse through the lists for mismatch and LCA
        # since we are maintaing the p and q twice in both lists, we do not need to worry about 
        # out of bound, there will be a mismatch either way
        # so we can traverse on either p or q
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                # node previous to the mismatch
                return self.pathP[i - 1]
        
        return None
    
    def dfs(self, root, p, q, path):
        # base case
        if root is None:
            return

        # logic
        # add the node to the list
        path.append(root)
        if root == p:
            self.pathP = path[:]
            self.pathP.append(p)
        
        if root == q:
            self.pathQ = path[:]
            self.pathQ.append(q)
        
        # recusrive calls
        self.dfs(root.left, p, q, path)
        self.dfs(root.right, p, q, path)

        # backtrack - remove the last added element
        path.pop()

