# TC: O(N) since we are iterating over all the nodes. 
# SC: O(H) where H is the height of the recursive stack.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def recurse(root):
#             base
            if not root: 
                return None
            if root == p: 
                return p
            if root == q: 
                return q
#             logic
            left = recurse(root.left)
            right = recurse(root.right)
            
            if left and right: 
                return root
            elif not left and right: 
                return right
            elif not right and left: 
                return left
            else: 
                return None
        
        return recurse(root)
