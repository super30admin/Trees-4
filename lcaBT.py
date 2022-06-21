#Time Complexity: O(n)
#Space Complexity: O(h)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        return self.helper(root,p,q)
        
    def helper(self,root,p,q):
        
        if root == None or root == p or root ==q:
            return root
        
        left = self.helper(root.left,p,q)
        
        right = self.helper(root.right,p,q)
        
        if left!= None and right!= None:
            return root
        
        elif left == None and right !=None:
            return right
        
        else:
            return left
        
        