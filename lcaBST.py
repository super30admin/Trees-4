#As taught in class usiing backtracing to solve this problem
#Time Complexity: O(2^n)
#Space Complexiity: O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p1 = self.helper(root,p,[])
        p2 = self.helper(root,q,[])
        for i in range(len(p1)):
            if (p1[i]!=p2[i]):
                return p1[i-1]
        return None
    
    def helper(self,root,p,path):
        if root is None:
            return path
        if root == p:
            path.append(root)
            return
        path.append(root)
        self.helper(root.left,p,path)
        if (path[len(path)-1] == p):
            return path
        del path[-1]
        self.helper(root.right,p,path)
        del path[-1]