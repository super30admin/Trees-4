# Time Complexity: O(n) 
# Space Complexity: O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pathP = []
        self.pathQ = []
        self.helper(root, p, q, [])
        
        for i in range(len(self.pathP)):
            if i < len(self.pathQ) and self.pathP[i].val != self.pathQ[i].val:
                return self.pathP[i-1]
        
        return self.pathP[-1] if len(self.pathP) <= len(self.pathQ) else self.pathQ[-1]
    
    def helper(self, root, p, q, path):
        if root is None:
            return
        
        path.append(root)
        if root == p:
            self.pathP = path[:]
        if root == q:
            self.pathQ = path[:]
        
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        path.pop()
