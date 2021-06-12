# TC: O(N) where N is the number of nodes of the binary tree
# SC: O(H) where H is the height of the recursive stack.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def backtrack(root, p, path): 
#             base
            if not root: 
                return
            
            if root == p:
                path.append(root)
                path.append(root)
                return
            
#             action
            path.append(root)
#             recurse
            backtrack(root.left, p, path)
            backtrack(root.right, p, path)
            if path[-1] == p: 
                return
#             backtrack
            path.pop()
        
        path1 = []
        path2 = []
        backtrack(root, p, path1)
        backtrack(root, q, path2)
        
        for i in range(len(path1)): 
            if path1[i] != path2[i]: 
                return path1[i - 1]
        
        return None
