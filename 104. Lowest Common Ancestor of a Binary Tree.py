# Time Complexity: O(h)
# Space Complexity: O(h)

class Solution:
    def __init__(self):
        self.p_path = []  
        self.q_path = [] 
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None: return None
        path = []
        self.helper(root, p, q, path.copy())
        for i in range(len(self.p_path)):
            if self.p_path[i] != self.q_path[i]:
                return self.p_path[i-1]
        return None
    
    def helper(self, root, p, q, path):
        #base
        if root is None: return
        
        #logic
        #action
        path.append(root)
        if root == p:
            self.p_path = path.copy()
            self.p_path.append(root)
            
        if root == q:
            self.q_path = path.copy()
            self.q_path.append(root)
        
        #recurse
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        #backtrack
        path.pop()
        