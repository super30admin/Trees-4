# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Method 1. Recrusion - O(N) TC and SC
        # if root.val>p.val and root.val>q.val: return self.lowestCommonAncestor(root.left,p,q) #if root bigger than both move left
        # elif root.val<p.val and root.val<q.val: return self.lowestCommonAncestor(root.right,p,q) #if root bigger than both move right
        # else: return root #else 1. bigger than one but smaller than other, 2. bigger than one and equal to another, 3. smaller than one and equal to another -> in all 3 cases you are at the LCA.

        #Method 2. Iterative - O(N) TC and O(1)SC
        while True:
            if root.val>p.val and root.val>q.val: root=root.left #if root bigger than both move left
            elif root.val<p.val and root.val<q.val: root=root.right #if root bigger than both move right
            else: return root #else 1. bigger than one but smaller than other, 2. bigger than one and equal to another, 3. smaller than one and equal to another -> in all 3 cases you are at the LCA.