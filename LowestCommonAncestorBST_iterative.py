# TC: O(logN) in average case, since we would be skipping half side of tree if p and q are greater or lesser than the root and O(N) in worst case. 
# SC: O(1) since we do not use any extra space.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True: 
            if p.val < root.val and q.val < root.val: 
                root = root.left
                
            elif p.val > root.val and q.val > root.val: 
                root = root.right
            else: 
                return root
        
