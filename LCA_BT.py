# Approach:
# This solution finds the Lowest Common Ancestor (LCA) of two nodes in a general Binary Tree (BT).
# It uses a recursive depth-first search (DFS) strategy:
#   - If the current node is None, or matches p or q, return the current node.
#   - Recursively search the left and right subtrees.
#   - If both left and right recursive calls return non-null, the current node is the LCA.
#   - If only one side returns non-null, propagate that non-null value upwards.
#
# Time Complexity: O(N), where N is the number of nodes in the tree.
#   - Each node is visited once.
#
# Space Complexity: O(H), where H is the height of the tree.
#   - This is the maximum depth of the recursion stack.
#   - In the worst case (skewed tree), H = N.
#   - In the best case (balanced tree), H = log N.

from collections import deque
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        def dfs(root):
            if not root or root == p or root == q:
                return root
            left = dfs(root.left)
            right = dfs(root.right)
            if left and right:
                return root
            if left:
                return left
            if right:
                return right
        return dfs(root)

# Helper function to insert nodes into BT
def insert_bt(vals):
    if not vals or vals[0] is None:
        return None
    root = TreeNode(vals[0])
    queue = deque([root])
    i = 1
    while queue and i < len(vals):
        node = queue.popleft()
        if i < len(vals) and vals[i] is not None:
            node.left = TreeNode(vals[i])
            queue.append(node.left)
        i += 1
        if i < len(vals) and vals[i] is not None:
            node.right = TreeNode(vals[i])
            queue.append(node.right)
        i += 1
    return root

# Helper function to find a node by value
def find_node(root, val):
    if not root:
        return None
    if root.val == val:
        return root
    left = find_node(root.left, val)
    if left:
        return left
    return find_node(root.right, val)

# Main function to test the LCA function
def main():
    # Example BST: [3,5,1,6,2,0,8,null,null,7,4]
    vals = [3,5,1,6,2,0,8,7,4]
    root = insert_bt(vals)
    
    solution = Solution()
    
    # Test case 1: p = 5, q = 1, LCA should be 3
    p = find_node(root, 5)
    q = find_node(root, 1)
    lca = solution.lowestCommonAncestor(root, p, q)
    print(f"LCA of 5 and 1: {lca.val if lca else None}")  # Output: 3

    # Test case 2: p = 5, q = 4, LCA should be 5
    p = find_node(root, 5)
    q = find_node(root, 4)
    lca = solution.lowestCommonAncestor(root, p, q)
    print(f"LCA of 5 and 4: {lca.val if lca else None}")  # Output: 5

if __name__ == "__main__":
    main()