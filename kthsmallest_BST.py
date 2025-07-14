# Approach:
# This solution finds the kth smallest element in a Binary Search Tree (BST).
# It uses an in-order traversal (DFS), which visits nodes in ascending order for a BST.
# The algorithm decrements a counter (self.count) each time it visits a node.
# When self.count reaches 0, it records the current node's value as the result.
# The traversal stops early once the kth smallest is found.
#
# Time Complexity: 
#   - In the worst case, if k is large or the tree is skewed, it may visit up to all nodes: O(N).
#
# Space Complexity: O(H), where H is the height of the tree.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthSmallest(self, root, k):
        self.count = k
        self.res = 0
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            self.count -= 1
            if self.count == 0:
                self.res = root.val
            dfs(root.right)
        dfs(root)
        return self.res

# Helper function to insert nodes into BST
def insert_bst(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_bst(root.left, val)
    else:
        root.right = insert_bst(root.right, val)
    return root

def build_bst_from_list(vals):
    root = None
    for v in vals:
        root = insert_bst(root, v)
    return root

def main():
    # Example BST: [5, 3, 6, 2, 4, 1]
    vals = [5, 3, 6, 2, 4, 1]
    root = build_bst_from_list(vals)
    solution = Solution()
    
    # Test case 1: k = 3 (should return 3)
    k = 3
    print(f"{k}rd smallest: {solution.kthSmallest(root, k)}")  # Output: 3

    # Test case 2: k = 1 (should return 1)
    k = 1
    print(f"{k}st smallest: {solution.kthSmallest(root, k)}")  # Output: 1

    # Test case 3: k = 5 (should return 5)
    k = 5
    print(f"{k}th smallest: {solution.kthSmallest(root, k)}")  # Output: 5

if __name__ == "__main__":
    main()