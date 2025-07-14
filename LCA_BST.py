# Approach:
# This solution finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).
# It leverages the BST property:
#   - All nodes in the left subtree have values less than the root.
#   - All nodes in the right subtree have values greater than the root.
# The algorithm recursively traverses the tree:
#   - If both p and q are less than root, LCA is in the left subtree.
#   - If both p and q are greater than root, LCA is in the right subtree.
#   - Otherwise, root is the LCA (split point).
#
# Time Complexity: O(H), where H is the height of the BST.
#   - In the worst case (skewed tree), H = N (number of nodes).
#   - In the best case (balanced tree), H = log N.
#
# Space Complexity: O(H), due to the recursion stack.

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        def dfs(root):
            if not root or not p or not q:
                return
            if max(p.val,q.val) < root.val:
                return dfs(root.left)
            if min(p.val,q.val) > root.val:
                return dfs(root.right)
            else:
                return root
        return dfs(root)

# Helper function to insert nodes into BST
def insert_bst(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_bst(root.left, val)
    else:
        root.right = insert_bst(root.right, val)
    return root

# Helper function to find a node by value
def find_node(root, val):
    while root:
        if val < root.val:
            root = root.left
        elif val > root.val:
            root = root.right
        else:
            return root
    return None

# Main function to test the LCA function
def main():
    # Example BST: [5,3,6,2,4,null,null,1]
    vals = [5, 3, 6, 2, 4, 1]
    root = None
    for v in vals:
        root = insert_bst(root, v)
    
    solution = Solution()
    
    # Test case 1: p = 2, q = 4, LCA should be 3
    p = find_node(root, 2)
    q = find_node(root, 4)
    lca = solution.lowestCommonAncestor(root, p, q)
    print(f"LCA of 2 and 4: {lca.val if lca else None}")  # Output: 3

    # Test case 2: p = 1, q = 4, LCA should be 3
    p = find_node(root, 1)
    q = find_node(root, 4)
    lca = solution.lowestCommonAncestor(root, p, q)
    print(f"LCA of 1 and 4: {lca.val if lca else None}")  # Output: 3

    # Test case 3: p = 3, q = 6, LCA should be 5
    p = find_node(root, 3)
    q = find_node(root, 6)
    lca = solution.lowestCommonAncestor(root, p, q)
    print(f"LCA of 3 and 6: {lca.val if lca else None}")  # Output: 5

if __name__ == "__main__":
    main()