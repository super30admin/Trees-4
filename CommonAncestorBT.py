class Solution:
    def lowestCommonAncestor(self, root, p, q):
        if root==None or root==p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left == None and right == None:
            return None
        elif left != None and right == None:
            return left
        elif left == None and right != None:
            return right
        else:
            return root
        '''
        # Helper function to find the path from root to the target node
        def find_path(root, target, path):
            if not root:
                return False
            
            # Add current node to the path
            path.append(root)
            
            # If the current node is the target, return True
            if root == target:
                return True
            
            # Check the left and right subtree
            if (find_path(root.left, target, path) or find_path(root.right, target, path)):
                return True
            
            # If not found, remove current node and backtrack
            path.pop()
            return False
        
        # Find path to p and q
        path_p, path_q = [], []
        find_path(root, p, path_p)
        find_path(root, q, path_q)
        
        # Compare paths to find the LCA
        i = 0
        while i < len(path_p) and i < len(path_q) and path_p[i] == path_q[i]:
            i += 1
        
        # The last common element is the LCA
        return path_p[i - 1]
        '''
