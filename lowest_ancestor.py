class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def ancestor(root, p, q):
    while root:
        if p.val< root.val and q.val< root.val:
            root = root.left
        elif p.val>root.val and q.val>root.val:
            root = root.right
        else:
            return root.val
    return None

def insert(root, key):
    if root is None:
        return TreeNode(key)
    else:
        if key < root.val:
            root.left = insert(root.left, key)
        else:
            root.right = insert(root.right, key)
    return root

# Build the BST
root = TreeNode(6)
root = insert(root, 2)
root = insert(root, 8)
root = insert(root, 0)
root = insert(root, 4)
root = insert(root, 7)
root = insert(root, 9)
root = insert(root, 3)
root = insert(root, 5)

# Define nodes p and q
p = TreeNode(7)
q = TreeNode(8)

# Find the LCA of p and q
lca = ancestor(root, p, q)
print(lca)

    
# time complexity is O(H)
# space complexity is O(1)