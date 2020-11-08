"""
Leetcode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Approach 1: Recursive Approach
1. Start traversing the tree from the root node.
2. If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the
    other node in the left and right branches.
3. If either of the left or the right branch returns True, this means one of the two nodes was found below.
4. If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found
    the lowest common ancestor for the nodes p and q.
Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case we might be visiting
    all the nodes of the binary tree.
Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N
    since the height of a skewed binary tree could be N.
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        # Variable to store LCA node.
        self.ans = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def recurse_tree(current_node):

            # If reached the end of a branch, return False.
            if not current_node:
                return False

            # Left Recursion
            left = recurse_tree(current_node.left)

            # Right Recursion
            right = recurse_tree(current_node.right)

            # If the current node is one of p or q
            mid = current_node == p or current_node == q

            # If any two of the three flags left, right or mid become True.
            if mid + left + right >= 2:
                self.ans = current_node

            # Return True if either of the three bool values is True.
            return mid or left or right

        # Traverse the tree
        recurse_tree(root)
        return self.ans


# Approach 2: Iterative using parent pointers
# 1. Start from the root node and traverse the tree.
# 2. Until we find p and q both, keep storing the parent pointers in a dictionary.
# 3. Once we have found both p and q, we get all the ancestors for p using the parent dictionary and
#     add to a set called ancestors.
# 4. Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p,
#     this means this is the first ancestor common between p and q (while traversing upwards)
#     and hence this is the LCA node.

# Time Complexity : O(N), where N is the number of nodes in the binary tree. In the worst case we might be
#   visiting all the nodes of the binary tree.
# Space Complexity : O(N). In the worst case space utilized by the stack, the parent pointer dictionary and
#   the ancestor set, would be N each, since the height of a skewed binary tree could be N.

class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # Stack for tree traversal
        stack = [root]

        # Dictionary for parent pointers
        parent = {root: None}

        # Iterate until we find both the nodes p and q
        while p not in parent or q not in parent:

            node = stack.pop()

            # While traversing the tree, keep saving the parent pointers.
            if node.left:
                parent[node.left] = node
                stack.append(node.left)
            if node.right:
                parent[node.right] = node
                stack.append(node.right)

        # Ancestors set() for node p.
        ancestors = set()

        # Process all ancestors for node p using parent pointers.
        while p:
            ancestors.add(p)
            p = parent[p]

        # The first ancestor of q which appears in
        # p's ancestor set() is their lowest common ancestor.
        while q not in ancestors:
            q = parent[q]
        return q