#I implemented an iterative in-order traversal using a stack. The in-order traversal ensures that the nodes are visited in ascending order, which is key to finding the kth smallest element efficiently. I used a stack to simulate the recursive traversal: first pushing all left children of the current node onto the stack, then processing nodes by popping from the stack, and finally moving to the right child. During this process, I decrement a counter k each time I process a node. When k reaches zero, I return the value of the current node as it represents the kth smallest element. The space complexity of this approach is O(h), where h is the height of the tree, due to the stack storing nodes along the path from the root to a leaf. The time complexity is O(k), as we only need to process the first k nodes to find the kth smallest element.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stk = []
        while root or stk:
            while root:
                stk.append(root)
                root = root.left
            root = stk.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        return -1