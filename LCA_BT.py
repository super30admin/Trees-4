# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root==None or p==root or q==root:
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        if left!=None and right!=None:
            return root
        
        if left!=None :
            return left
        if right!=None:
            return right
        
        if left==None and right==None:
            return None
        