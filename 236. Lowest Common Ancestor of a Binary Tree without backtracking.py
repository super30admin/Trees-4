# Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case, we may have to visit all nodes to find the lowest common ancestor.
# Space Complexity: O(H), where H is the height of the binary tree. The space complexity is determined by the maximum depth of the recursion stack.

# Without backtracking
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Base case: if the current node is None or either p or q, return the node.
        if (root is None or root == p or root == q):
            return root

        print(root.val)  # Print the value of the current node (for debugging purposes).

        # Recur for the left and right subtrees to find the lowest common ancestors.
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # Determine the lowest common ancestor based on the results from the left and right subtrees.
        if (left is None and right is None):
            return None  # If both left and right are None, no common ancestor is found, return None.
        elif (left is not None and right is None):
            return left  # If only the left subtree has a common ancestor, return it.
        elif (right is not None and left is None):
            return right  # If only the right subtree has a common ancestor, return it.
        else:
            return root  # If both left and right subtrees have common ancestors, return the current node as the lowest common ancestor.
