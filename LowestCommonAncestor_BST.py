# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """Iterative Approach without using stack as we dont need the root elements from stack(using elements just for comparision)
        Time complexity-O(h)
        Space complexity-O(1)"""
        while root:
            if (p.val<root.val and q.val<root.val):
                root=root.left
            elif (p.val>root.val and q.val>root.val):
                root=root.right
            else:
                return root
        """Recursion
        Time Complexity-O(h)
        Space complexity-O(h)"""
        # if (p.val<root.val and q.val<root.val):
        #     return self.lowestCommonAncestor(root.left, p, q)
        # elif (p.val>root.val and q.val>root.val):
        #     return self.lowestCommonAncestor(root.right, p, q)
        # else:
        #     return root
        
        
        # if not root:
        #     return
        # if (p.val<=root.val and q.val>=root.val) or (q.val<=root.val and p.val>=root.val):
        #     return root
        # left= self.lowestCommonAncestor(root.left, p, q)
        # if left:
        #     return left
        # right= self.lowestCommonAncestor(root.right, p, q)
        # if right:
        #     return right
        