# Time Complexity : O(h)
# Space Complexity : O(h)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        elif root.val > max(p.val, q.val):
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < min(p.val, q.val):
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root

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
root = build_tree([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5])
p = root.left # Node with value 2
q = root.right # Node with value 8
print(sol.lowestCommonAncestor(root, p, q).val) # Output: 6

# Example 2
root = build_tree([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5])
p = root.left # Node with value 2
q = root.left.right # Node with value 4
print(sol.lowestCommonAncestor(root, p, q).val) # Output: 2

# Example 3
root = build_tree([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5])
p = root.left.right.left # Node with value 3
q = root.left.right.right # Node with value 5
print(sol.lowestCommonAncestor(root, p, q).val) # Output: 4