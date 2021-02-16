#Time Complexity:O(n)
#Space complexity:O(n)
#Ran successfully on leetcode:yes
#Algorithm:
#Check if one of the roots is the parent and if not explore right and left child and do the same.
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    
        if root==p or root==q:
            return root
        left=None
        right=None
        if root.left:
            left=self.lowestCommonAncestor(root.left,p,q)
        if root.right:
            right=self.lowestCommonAncestor(root.right,p,q)
        if left and right:
            return root
        else:
            return left or right
      
