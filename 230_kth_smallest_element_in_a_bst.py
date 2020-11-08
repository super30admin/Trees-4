# Leetcode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
# Approach 1: Recursive Inorder Traversal
#   1. Build an inorder traversal of BST which is an array sorted in the ascending order.
#   2. The answer is the (k - 1)th element of this array.
#
# Time complexity : O(N) to build a traversal.
# Space complexity : O(N) to keep an inorder traversal.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        def inorder(r):
            if r:
                return inorder(r.left) + [r.val] + inorder(r.right)
            else:
                return []

        return inorder(root)[k - 1]


# Approach 2: Iterative Inorder Traversal
#     The above recursion could be converted into iteration, with the help of stack. This way one could speed up
#     the solution, because there is no need to build the entire inorder traversal,
#     and one could stop after the kth element.

# Time complexity: O(H+k), where H is a tree height. This complexity is defined by the stack,
#   which contains at least H+k elements, since before starting to pop out one has to go down to a leaf.
#   This results in O(logN+k) for the balanced tree and
#   O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
# Space complexity: O(H) to keep the stack, where H is a tree height. That makes O(N)
#   in the worst case of the skewed tree, and O(logN) in the average case of the balanced tree.

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []

        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if not k:
                return root.val
            root = root.right