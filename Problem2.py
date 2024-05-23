## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

# Approach
# Using BST property. if p & q are less than root.val, move left
# if val of p & q are greater than root.val, move right
# else, return root. 

# Time Complexity: O(h). If its a complete binary search tree - O(logn)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left,p,q)

        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right,p,q)
            
        else:
            return root