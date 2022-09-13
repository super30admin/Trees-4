#Time complexity: O(n)
#Space complexity: O(h)

#Approach - 1    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        
        self.helper(root, p, q, path)
        for i in range(len(self.pathp)):
            if self.pathp[i] != self.pathq[i]:
                return self.pathq[i-1]
            
        return None
    
    def helper(self, root, p, q, path):
        #base
        if root == None:
            return
        if root == p:
            self.pathp = path[:]
            self.pathp.append(root)
            self.pathp.append(root)
            
        if root == q:
            self.pathq = path[:]
            self.pathq.append(root)
            self.pathq.append(root)
            
        #logic
        #action
        path.append(root)
        #recurse
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        #backtrack
        path.pop()
        
        
        
#Approach - 2
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root  
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root 
        else:
            return left or right
