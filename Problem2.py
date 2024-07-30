#I implemented a solution that leverages the properties of the BST. In this approach, we start at the root and traverse the tree iteratively. If both target nodes p and q are smaller than the current node, we move to the left child, as the LCA must be in that subtree. Conversely, if both p and q are larger than the current node, we move to the right child, as the LCA is in that subtree. If one node is smaller and the other is larger or if one of them matches the current node, then the current node is the LCA. This method efficiently narrows down the search space based on BST properties. The time complexity of this solution is O(h), where h is the height of the tree, as we only traverse from the root to a leaf. The space complexity is O(1) because we use constant space for the traversal, excluding the input and output.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
            if p.val < root.val > q.val:
                root = root.left
            elif p.val > root.val < q.val:
                root = root.right
            else:
                return root