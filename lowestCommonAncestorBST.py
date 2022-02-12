class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper( root, p , q ):
            nonlocal lca
            if p == root or q == root and lca == None:
                lca = root
                return 
            if p.val > root.val and q.val > root.val :
                helper( root.right, p , q )
            if p.val < root.val and q.val < root.val:
                helper( root.left , p , q )
            if p.val < root.val < q.val or q.val < root.val < p.val and lca == None :
                lca = root
                return 
        lca = None
        helper(root, p , q)
        return lca
            
            
            
