class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper( root, p , q   ):
            nonlocal lca 
            # nonlocal counter
            # if not root:
            #     return 0
            counter = 0 
            if root.left:
                counter += helper(root.left , p , q  ) 
            if root.right:
                counter += helper( root.right , p , q   ) 
            if root == p or root == q:
                counter += 1
            if counter == 2 and lca == None:
                lca = root
            return counter
        lca = None 
        counter = 0 
        helper( root, p , q  )
        return lca
    
    
    
