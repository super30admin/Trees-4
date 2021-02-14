# Approach: Apply DFS and check for BST property to continue searching on left or right subtree
# Time - O(log N) # search space reduced to half 
# Space - O(H)


class Solution:
     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
         if not root:
             return None

        # p anf q are lesser than root, search on left(BST property)
         if p.val < root.val and q.val < root.val:
             return self.lowestCommonAncestor(root.left, p, q)

         if p.val > root.val and q.val > root.val:
             return self.lowestCommonAncestor(root.right, p, q)

         return root