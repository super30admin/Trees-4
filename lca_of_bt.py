# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        ## Approach 2: recursion
        ## T.C = O(n)
        ## S.C = O(h)

        def dfs2(root, p, q):
            if root is None or root == p or root == q:
                return root
            
            left = dfs2(root.left, p, q)
            right = dfs2(root.right, p, q)

            if left == None and right == None:
                return None
            elif (left == None) and (right != None):
                return right
            elif (left != None) and (right == None):
                return left
            else:
                return root
        
        return dfs2(root, p, q)

        ## Approach 1: recursion and backtracking
        ## T.C = O(n)
        ## S.C = O(h)

        path_p = []
        path_q = []
        res = []

        def dfs(root, p, q, path):
            #print(path)
            
            if not root:
                return
            
            if root == p:
                n_path = list(path)
                n_path.append(root)
                res.append(n_path)
                
            if root == q:
                n_path = list(path)
                n_path.append(root)
                res.append(n_path)
                
            path.append(root)
            
            dfs(root.left, p, q, path)
            dfs(root.right, p, q, path)

            path.pop()

        dfs(root, p, q, [])

        for i in range(len(res[0])):
            if res[0][i] != res[1][i]:
                return res[0][i-1]

        return res[0][-1]

  