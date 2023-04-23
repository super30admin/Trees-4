#Time Complexity : O(h)), h being the height of the tree. 
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to look at solution to find the strategy. 
'''Taking into consideration the property of binary search tree, return root if the value or root 
is between the value of p and q. Else, recurse. 
'''
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # left node if p and q are both less than root. 
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        # right node if p and q are both greater than root
        elif root.val<p.val and root.val<q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root