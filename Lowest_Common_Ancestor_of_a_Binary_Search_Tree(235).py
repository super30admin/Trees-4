# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Recursive Approach
        # TC: O(h) h->height of the tree
        # SC: O(h)
        # if a number satisifies a<=X<=b then that would be the result
        # if root is None:
        #     return None

        # if(root.val>p.val and root.val>q.val):
        #     return self.lowestCommonAncestor(root.left,p,q)
        # elif(root.val<p.val and root.val<q.val):
        #     return self.lowestCommonAncestor(root.right,p,q)
        # else:
        #     return root

        # Iterative Approach
        # TC: O(h)
        # SC: O(1)
        if root is None:
            return None

        while True:
            if(root.val>p.val and root.val>q.val):
                root = root.left
            elif(root.val<p.val and root.val<q.val):
                root = root.right
            else:
                return root