#Time complexity = O(n)
#Space Complexity = O(h)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left and right:
            return root  # If both sides return non-null, root is the LCA
        
        return left if left else right 
    
#Time complexity = O(n)
#Space Complexity = O(h)
#iterative solution 
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent = {} 
        stack = [root]  

        #for parent pointers
        while stack:
            node = stack.pop()
            if node.left:
                parent[node.left] = node
                stack.append(node.left)
            if node.right:
                parent[node.right] = node
                stack.append(node.right)

        # Store ancestors of p in a set
        ancestors = set()
        while p:
            ancestors.add(p)
            p = parent.get(p)

        # Traverse q's ancestors and find the first match
        while q not in ancestors:
            q = parent.get(q)

        return q  # The first common ancestor
