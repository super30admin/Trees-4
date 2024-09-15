"""
    // Time Complexity :O(h)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    check if the root > p and root > q; LCA lies in left side
    if root < p and root < q; LCA lies in right side
    else return root
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None

        return self.helper(root,p,q)

    def helper(self,root,p,q):
        # base case
        if root is None:
            return None

        # logic
        # if p and q are smaller than root; call left subtree
        if root.val > p.val and root.val > q.val:
            return self.helper(root.left,p,q)

        # if p and q are greater than root; call right subtree
        if root.val < p.val and root.val < q.val:
            return self.helper(root.right,p,q)

        return root
"""
# iterative solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root != None:
            if root.val > p.val and root.val > q.val: root = root.left
            elif root.val < p.val and root.val < q.val: root = root.right
            else:
                return root
"""
