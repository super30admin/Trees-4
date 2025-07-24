# ----------------------------------------------------
# LeetCode 230. Kth Smallest Element in a BST
#
# Intuition:
# A BST's inorder traversal yields nodes in ascending order.
#
# 1) Optimal Recursive (Early Stop):
#    - Do inorder traversal but stop as soon as we've visited k nodes.
#    - Time: O(h + k) (worst O(n)), Space: O(h) recursion stack.
#
# 2) Naive Recursive (Store Full Inorder):
#    - Build the full inorder array, then return arr[k-1].
#    - Time: O(n), Space: O(n).
#
# 3) Iterative Inorder (Early Stop):
#    - Same idea as (1) but using an explicit stack.
#    - Time: O(h + k) (worst O(n)), Space: O(h).
#
# 4) Follow-up (Augmented BST):
#    - Each node maintains size of its subtree.
#    - Use sizes to navigate to kth smallest in O(h).
#    - Insert/Delete must update sizes on the path -> O(h).
# ----------------------------------------------------

from typing import Optional

class TreeNode:
    def __init__(self, val = 0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    # ----------------------------------------------------
    # 1) Optimal Recursive (Early Stop)  <-- default
    # Time: O(h + k)  (worst-case O(n))
    # Space: O(h)     recursion stack
    # ----------------------------------------------------
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.ans = None

        def inorder(node: Optional[TreeNode]) -> None:
            if not node or self.ans is not None:
                return
            inorder(node.left)
            self.k -= 1
            if self.k == 0:
                self.ans = node.val
                return
            inorder(node.right)

        inorder(root)
        return self.ans

    # ----------------------------------------------------
    # 2) Naive Recursive (Store Full Inorder)
    # Time: O(n)
    # Space: O(n)
    # ----------------------------------------------------
    def kthSmallest_naive(self, root: Optional[TreeNode], k: int) -> int:
        arr = []

        def inorder(node: Optional[TreeNode]) -> None:
            if not node:
                return
            inorder(node.left)
            arr.append(node.val)
            inorder(node.right)

        inorder(root)
        return arr[k - 1]

    # ----------------------------------------------------
    # 3) Iterative Inorder (Early Stop)
    # Time: O(h + k)  (worst-case O(n))
    # Space: O(h)
    # ----------------------------------------------------
    def kthSmallest_iterative(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        curr = root

        # Traverse until we've processed k nodes
        while stack or curr:
            # Go as left as possible
            while curr:
                stack.append(curr)
                curr = curr.left

            # Visit the next node
            curr = stack.pop()
            k -= 1
            if k == 0:
                return curr.val

            # Then go right
            curr = curr.right

        return -1  # Should never hit if inputs are valid (1 <= k <= n)

    # ----------------------------------------------------
    # 4) Follow-up: Augmented BST node & kthSmallest using sizes
    # Time per query: O(h)    (O(log n) if balanced)
    # Space: O(1) extra (not counting the tree itself)
    # NOTE: You must maintain `size` on every insert/delete.
    # ----------------------------------------------------
    class AugNode:
        def __init__(self, val: int):
            self.val = val
            self.left: Optional['Solution.AugNode'] = None
            self.right: Optional['Solution.AugNode'] = None
            self.size: int = 1  # size of subtree rooted at this node

    def kthSmallest_augmented(self, root: 'AugNode', k: int) -> int:
        curr = root
        while curr:
            left_size = curr.left.size if curr.left else 0
            if k == left_size + 1:
                return curr.val
            elif k <= left_size:
                curr = curr.left
            else:
                k -= (left_size + 1)
                curr = curr.right
        return -1  # Should not happen if k is valid


# ----------------------------------------------------
# Example Usage
# ----------------------------------------------------
if __name__ == "__main__":
    # Build BST:
    #        5
    #       / \
    #      3   6
    #     / \
    #    2   4
    #   /
    #  1
    n1 = TreeNode(1)
    n2 = TreeNode(2, left=n1)
    n4 = TreeNode(4)
    n3 = TreeNode(3, left=n2, right=n4)
    n6 = TreeNode(6)
    n5 = TreeNode(5, left=n3, right=n6)

    sol = Solution()

    print("kth Samllest:", sol.kthSmallest(n5, 3))        # 3

    # Follow-up example (manually setting sizes)
    # Same shape using AugNode
    a1 = Solution.AugNode(1)
    a2 = Solution.AugNode(2); a2.left = a1
    a4 = Solution.AugNode(4)
    a3 = Solution.AugNode(3); a3.left = a2; a3.right = a4
    a6 = Solution.AugNode(6)
    a5 = Solution.AugNode(5); a5.left = a3; a5.right = a6

    # Set subtree sizes (these would be maintained on insert/delete in practice)
    a1.size = 1
    a2.size = 2
    a4.size = 1
    a3.size = 4
    a6.size = 1
    a5.size = 6

    print("Augmented:", sol.kthSmallest_augmented(a5, 3))      # 3
