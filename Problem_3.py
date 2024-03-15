'''
Time Complexity - O(n). We are traversing the entire tree
Space Complexity - O(h) recursive stack space that is same as height of the tree

Works on Leetcode.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def __init__(self):
        self.pathP = None
        self.pathQ = None
        self.flagP = False
        self.flagQ = False
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #self.dfs(root, p, q, [])
        # for i in range(len(self.pathP)):
        #     if self.pathP[i]!=self.pathQ[i]:
        #         return self.pathP[i-1]
        return self.dfs2(root, p, q)
        
    
    def dfs(self, root, p, q, path):
        if root == None: #return None if root is none
            return None
        path.append(root)
        if root == p:
            self.pathP = path[:] #if root is same as P store a deep copy of the path
            self.pathP.append(root)#create an extra entry of the root
            self.flagP = True
        
        if root == q:
            self.pathQ = path[:]#if root is same as Q store a deep copy of the path
            self.pathQ.append(root)#create an extra entry of the root
            self.flagQ = True

        if not self.flagP or not self.flagQ:
            self.dfs(root.left, p, q, path) #go to left child if p or q not yet found
        if not self.flagP or not self.flagQ:
            self.dfs(root.right, p, q, path) #go to right child if p or q not yet found 
        path.pop()
    
    def dfs2(self, root, p, q):
        if root == None or root == p or root ==q:
            return root

        left = self.dfs2(root.left, p, q) #look in left subtree
        right = self.dfs2(root.right, p, q) #look in right subtree

        if left == None and right == None:#for leaf node
            return None 
        elif left == None and right != None:#when the p or q is found in a right subtree 
            return right 
        elif left != None and right == None:#when p or q is found in left subtree
            return left
        else:
            return root #return the root when both left child and right child not null

        