# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if not root:
    #         return None

    #     self.path1 = []
    #     self.path2 = []

    #     self.backtrack(root, p, q, [])

    #     # to account for mismatched lengths whenever we see target we add node twice
    #     for i in range(len(self.path1)):
    #         if self.path1[i] != self.path2[i]:
    #             return self.path1[i - 1]
    #     return None

    # def backtrack(self, root, p, q, path):
    #     # base case

    #     if not root or (self.path1 and self.path2):
    #         return

    #     # action
    #     path.append(root)

    #     if root == p:
    #         # to account for mismatched lengths whenever we see target we add node twice
    #         self.path1 = path.copy()
    #         self.path1.append(root)

    #     if root == q:
    #         # to account for mismatched lengths whenever we see target we add node twice
    #         self.path2 = path.copy()
    #         self.path2.append(root)

    #     # recurse
    #     self.backtrack(root.left, p, q, path)
    #     self.backtrack(root.right, p, q, path)

    #     # backtrack
    #     path.pop()

    #     if not root:
    #         return None
        
    #     return self.recurse(root, p, q)


    # def recurse(self, root, p, q):
    #     #base case
    #     if not root or root == p or root == q:
    #         return root 
    #     #logic
    #     left = self.recurse(root.left, p, q)
    #     right = self.recurse(root.right, p, q)
    #     if not left and not right:
    #         return None
    #     if not left and right:
    #         return right
    #     if left and not right:
    #         return left
    #     else:
    #         return root

        if not root:
            return None
        self.listp = []
        self.listq = []

        self.recurse(root, p, q, [])
        for i in range(len(self.listp)):
            if self.listp[i].val != self.listq[i].val:
                return self.listp[i - 1]
        return None
    
    def recurse(self, root, p, q, path):
        if not root:
            return None
        path.append(root)
        if root.val == p.val:
            self.listp = path.copy()
            self.listp.append(root)
        
        if root.val == q.val:
            self.listq = path.copy()
            self.listq.append(root)
        
        self.recurse(root.left, p, q, path)
        self.recurse(root.right, p, q, path)

        path.pop()
        

