# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Approach:
        1. Since this is a Binary Search Tree (BST), the lowest common ancestor (LCA) lies between the values of p and q.
        2. Traverse the tree:
           - If both p and q are smaller than current node, go left.
           - If both are larger, go right.
        3. The first node where the split happens (one value on the left and one on the right, or one equals current) is the LCA.

        Time Complexity: O(log N) for balanced BST, O(N) in worst case (skewed tree).
        Space Complexity: O(1), iterative traversal without recursion or extra data structures.
        """

        curr = root

        while curr:
            if curr.val > p.val and curr.val > q.val:
                curr = curr.left
            elif curr.val < p.val and curr.val < q.val:
                curr = curr.right
            else:
                return curr
