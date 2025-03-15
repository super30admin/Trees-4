# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root
        
# TC: O(h) --> best case: O(log n) worst case: O(n)
# SC: O(h)


################### Backtracking Solution ###################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathP = []
        self.pathQ = []
        self.backtrack(root,p,q,[])
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]

    
    def backtrack(self,root,p,q,path):
        # base
        if root == None:
            return
        # logic
        #action
        path.append(root)
        if root == p:
            self.pathP = path.copy()
            self.pathP.append(root)
        if root == q:
            self.pathQ = path.copy()
            self.pathQ.append(root)
        #recurse
        self.backtrack(root.left,p,q,path)
        self.backtrack(root.right,p,q,path)
        #backtrack
        path.pop()

# TC: O(n)
# SC: O(h)


###################3 Solution 3: Recursive bottom up apprach ########################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        if left == None and right == None:
            return None
        elif left != None and right == None:
            return left
        elif left == None and right != None:
            return right
        else:
            return root

# TC: O(n)
# SC: O(h) recursive stack space