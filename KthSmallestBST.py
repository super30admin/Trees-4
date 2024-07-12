# Time Complexity : O(n), where n is the number of the nodes
# Space Complexity : O(h), where h is the heigh of the tree

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.count = 0
        self.result = -1
    
    def inOrder(self, root: 'TreeNode', k: int):
        if root is None:
            return
        
        self.inOrder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        self.inOrder(root.right, k)
    
    def kthSmallest(self, root: 'TreeNode', k: int) -> int:
        if root is None or k == 0:
            return -1
        
        self.count = 0
        self.result = -1
        self.inOrder(root, k)
        return self.result

# Helper function to build a tree from a list
def build_tree(nodes):
    if not nodes:
        return None
    val = nodes.pop(0)
    root = TreeNode(val) if val is not None else None
    queue = [root]
    while nodes:
        node = queue.pop(0)
        if node:
            left_val = nodes.pop(0) if nodes else None
            right_val = nodes.pop(0) if nodes else None
            node.left = TreeNode(left_val) if left_val is not None else None
            node.right = TreeNode(right_val) if right_val is not None else None
            queue.append(node.left)
            queue.append(node.right)
    return root

# Test cases
sol = Solution()

# Example 1
root = build_tree([3, 1, 4, None, 2])
k = 1
print(sol.kthSmallest(root, k)) # Output: 1

# Example 2
root = build_tree([5, 3, 6, 2, 4, None, None, 1])
k = 3
print(sol.kthSmallest(root, k)) # Output: 3

# Example 3
root = build_tree([2, 1, 3])
k = 2
print(sol.kthSmallest(root, k)) # Output: 2