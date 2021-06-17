class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.dict = {}
        def inorder(root):
            if not root: 
                return
            
            inorder(root.left)
            if root.left:
                self.dict[root.left] = root
            if root.right:
                self.dict[root.right] = root
            
            inorder(root.right)
        
        inorder(root)
        
        def make_list(x, xlist): 
            while xlist[-1] != None
                parent = self.dict.get(x)
                xlist.append(parent)
                x = parent
        
        p_list = []
        p_list.append(p)
        make_list(p, p_list)
        q_list = []
        q_list.append(q)
        make_list(q, q_list)
        
        for i in p_list: 
            if i in q_list: 
                return i
        
