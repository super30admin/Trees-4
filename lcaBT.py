#TC - O(N)
#SC - O(N)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root,p,q):
            if root == None or root == p or root == q:
                return root
            left = dfs(root.left,p,q)
            right = dfs(root.right,p,q)
            if left is None:
                return right
            elif right is None:
                return left
            else:
                return root 
        return dfs(root,p,q)