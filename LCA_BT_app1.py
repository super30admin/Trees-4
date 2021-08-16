# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#Time Complexity: O(N)

#Space Complexity: O(H) where H is the height of the tree

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.result =TreeNode(None)
        self.path1 = []
        self.path2 = []
        if not root:
            return root
        
        def backtrackpath(node,path):
            if not node:
                return root
            if node==p:
                self.path1 = list(path)
                self.path1.append(p.val)
                self.path1.append(p.val)
            if node == q:
                self.path2 = list(path)
                self.path2.append(q.val)
                self.path2.append(q.val)
            
            path.append(node.val)
            backtrackpath(node.left,path)
            backtrackpath(node.right,path)
            path.pop()
            
                
        backtrackpath(root,[])

        for i in range(len(self.path1)):
            if self.path1[i]!=self.path2[i]:
                self.result = TreeNode(self.path1[i-1])
                break
        return self.result