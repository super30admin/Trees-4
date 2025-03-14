# Problem 3 : Lowest Common Ancestor of a Binary Tree
# Time Complexity :
'''
Recursion- O(n) where n is the number of nodes
Backtracking - O(n) where n is the number of nodes
'''
# Space Complexity :
'''
Recursion-  O(h) where h is the height of the tree
Backtracking- O(h) where h is the height of the tree
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Recursion

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # edge case if root is None or root is either p or q then return root
        if root == None or root == p or root == q:
            return root
        
        # call the lowestCommonAncestor for left and right side of the node
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # compare the left and right 
        # if both are None then return None
        if left == None and right == None:
            return None
        # if one of them is None and one is not then return non None value
        elif left != None and right == None:
            return left
        elif left == None and right != None:
            return right
        # if both of them are not None then return root
        else:
            return root
        
# Backtracking solution

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    '''def __init__(self):
        self.pathP = []
        self.pathQ = []'''

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # edge case if root is None then return None
        if root is None:
            return None
        # two path for node p and q
        pathP = []
        pathQ = []

        # backtrack function to get the path for p and q node
        def backtrack(root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', path: list) -> None:
            # opath for p and q are global
            nonlocal pathQ, pathP
            # Base case if the root is None then return
            if root is None:
                return
            
            # Add the current root to the path
            path.append(root)
            # check if the root is p
            if root == p:
                # if it is then create a copy of the path and save in pathP
                pathP = path.copy()
                # add the node p again to pathP to avoid end of list while comparing both the path list
                pathP.append(p)
            # check if the root is q
            if(root == q):
                # if it is then create a copy of the path and save in pathQ
                pathQ = path.copy()
                # add the node q again to pathQ to avoid end of list while comparing both the path list
                pathQ.append(q)
            
            # call backtrack function for left and right part of the node
            backtrack(root.left, p, q, path)
            backtrack(root.right, p, q, path)
            # backtrack action to pop the last element from the path
            path.pop()

        # call backtrack function from root
        backtrack(root, p, q, [])
        # compare the path list of p and q node to find the last common element
        for i in range(len(pathQ)):
            # if the elements are not same at i position then previous element is the lowest common element
            if pathQ[i] != pathP[i]:   
                # return the previous element
                return pathQ[i-1]
        return None
    
    
        
