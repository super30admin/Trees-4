#Time Complexity :- O(n)+O(h)
#Space Complexity :- O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    pPath = []
    qPath = []
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pPath = []
        self.qPath = []
        if root is None:
            return root
        self.dfs(root, p, q, [])
        print(self.pPath,"Qpath:", self.qPath)
        for i in range(len(self.pPath)):
            if self.pPath[i]!= self.qPath[i]:
                return self.pPath[i-1]


    def dfs(self, root, p, q, path):
        if root is None:
            return
        path.append(root)
        if root == p:
            self.pPath = path.copy()
            print(self.pPath)
            self.pPath.append(p) 
        
        if  root == q:
            self.qPath = path.copy()
            self.qPath.append(q)
        
        self.dfs(root.left, p, q, path)
        self.dfs(root.right, p, q, path)
        path.pop()


#ANother approach and optimised:
#Time Complexity :- O(n)
#Space Complexity :- O(h)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root 
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None : 
            return None
        elif left is not None and right is None:
            return left
        elif right is not None and left is None:
             return right
        else:
            return root
