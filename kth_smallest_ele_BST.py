# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# using max-heap
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        max_heap = []

        def inorder_traversal(node):
            if not node:
                return

            inorder_traversal(node.left)

            if len(max_heap) < k:
                heapq.heappush(max_heap, -node.val)
            else:
                if -node.val > max_heap[0]:
                    heapq.heappop(max_heap)
            inorder_traversal(node.right)

        inorder_traversal(root)
        return -max_heap[0]
        # time complexity is O(nlogk)
        # space complexity is O(n)


# iterative approach
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []

        while stack or root is not None:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k = k - 1
            if k == 0:
                return root.val
            root = root.right
        return -1

    # time complexity is O(N+k)
    # space complexity is O(N)#
