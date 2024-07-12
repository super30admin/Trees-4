# Time Complexity : O(n), where n is the number of the nodes
# Space Complexity : O(h), where h is the heigh of the tree

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root.val == p.val or root.val == q.val:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if not left:
            return right
        elif not right:
            return left
        
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
root = build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
p = root.left # Node with value 5
q = root.left.right.right # Node with value 4
print(sol.lowestCommonAncestor(root, p, q).val) # Output: 5

# Example 2
root = build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
p = root.left # Node with value 5
q = root.right # Node with value 1
print(sol.lowestCommonAncestor(root, p, q).val) # Output: 3

# Example 3
root = build_tree([1, 2])
p = root # Node with value 1
q = root.left # Node with value 2
print(sol.lowestCommonAncestor(root, p, q).val) # Output: 1