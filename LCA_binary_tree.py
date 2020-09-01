class Solution:
    def __init__(self):
        self.ans = None
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(node):
            if not node:
                return False
            left=helper(node.left)
            right=helper(node.right)
            mid=node==p or node==q
            if mid+left+right>=2:
                self.ans=node
            return mid or left or right
        helper(root)
        return self.ans

#Time-Complexity: O(N)
#Space-Complexity: O(N)