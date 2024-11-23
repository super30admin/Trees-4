#Time Complexity: O(h), where h is the height of the tree, as the algorithm only traverses down one branch in a binary search tree.
#Space Complexity: O(h), due to the recursive call stack.
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if(p.val < root.val and q.val < root.val):
            return self.lowestCommonAncestor(root.left, p , q)
        elif(p.val > root.val and q.val > root.val):
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root