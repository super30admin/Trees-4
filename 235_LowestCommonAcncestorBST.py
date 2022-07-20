# Time Complexity : O(log(n))
# Space Complexity: O(1)


# Definition for a binary tree node.
# class TreeNode:
#      def __init__(self, x):
#          self.val = x
#          self.left = None
#          self.right = None


# do inorder traversal
# if p and q both are smalller than root, go left side
# if p and q both are bigher than root, go left side
# if one is small and another one id greater than root, return that root
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # without recursion
        while (root != None):
            if (p.val < root.val and q.val < root.val):
                root = root.left
            elif (p.val > root.val and q.val > root.val):
                root = root.right
            else: 
                return root
    
    def lowestCommonAncestor2(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # with recursion
        if (p.val < root.val and q.val < root.val):
            self.lowestCommonAncestor2(root.left,p,q)
        elif (p.val > root.val and q.val > root.val):
            self.lowestCommonAncestor2(root.right,p,q)
        else: 
            return root
    
