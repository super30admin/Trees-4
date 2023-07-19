# Time Complexity : O(H) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use recursion and return values if the given p and q are present then return the root accordingly.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root == None or root == p or root == q):
            return root
        left = self.lowestCommonAncestor(root.left, p ,q)
        right = self.lowestCommonAncestor(root.right, p ,q)
        if(left == None and right == None):
            return None
        elif(left != None and right == None):
            return left
        elif(right != None and left == None):
            return right
        else:
            return root