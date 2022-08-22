""" 
Runtime Complexity:
O(h) - for both recursive and iterative solution. We check and compare the value of p and q with the root and only traverse either right or left side by avoiding all traversal of all nodes.
Space Complexity:
O(h) - recursive solution -recursive stack space.
O(1) - no extra data structure was used to compute the solution.
Yes, the code worked on leetcode.
Issues while coding-No
"""
#Iterative Approach
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return root
        while True:
            if (root.val>p.val and root.val>q.val):
                root = root.left
            elif (root.val<p.val and root.val <q.val):
                root = root.right
            else:
                return root


#Recursive approach
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return root

        if (root.val>p.val and root.val>q.val):
            return self.lowestCommonAncestor(root.left,p,q)
        elif (root.val<p.val and root.val <q.val):
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root

        