# Time Complexity: O(h) height of the tree
# Space Complexity: O(h) recursive stack
# Recursive solution
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if root == None:
#             return None
#         if root.val > p.val and root.val > q.val:
#             return self.lowestCommonAncestor(root.left,p,q)
#         elif root.val < p.val and root.val < q.val:
#             return self.lowestCommonAncestor(root.right,p,q)
#         else:
#             return root


# Time Complexity: O(h) height of the tree
# Space Complexity: O(1) 
# Iterative solution
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        curr = root
        while curr != None:
            if curr.val > p.val and curr.val > q.val:
                curr = curr.left
            elif curr.val < p.val and curr.val < q.val:
                curr = curr.right
            else:
                return curr
        return None