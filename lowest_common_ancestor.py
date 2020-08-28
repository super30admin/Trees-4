class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p_val=p.val
        q_val=q.val
        node=root
        while node:
            parent_val=node.val
            if p_val > parent_val and q_val>parent_val:
                node=node.right
            elif p.val<parent_val and q_val<parent_val:
                node=node.left
            else:
                return node
#Time-complexity:O(N)
#space-complexity:O(1)