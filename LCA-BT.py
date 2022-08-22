"""
Runtime Complexity:
O(n) - we traverse all the node to compute the ancestor. We push the computed value to the root of the tree and return the answer. This is
better approach then the brute force but th easymptotic runtime notation is same for both the solution.
Space Complexity:
O(h) - recursive stack space.
Yes, the code worked on leetcode.
Issues while coding-NO
"""

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root ==p or root==q:
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        if not left and not right:
            return None
        if left!=None and right==None:
            return left
        if left==None and right!=None:
            return right
        else:
            return root