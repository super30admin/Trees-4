# TC: O(n)
# SC: O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root,p,q):
            #base
            if not root or root is p or root is q:
                return root
            #logic
            left=helper(root.left,p,q)
            right=helper(root.right,p,q)
            if left and not right:
                return left
            
            if right and not left:
                return right
            
            if left and right:
                print(root.val, left.val, right.val)
                return root
            
            else:
                return None
        
        return helper(root,p,q)
