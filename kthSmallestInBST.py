# Time Complexity : O(N)
# Space Complexity : O(h)

# Approach:
# 1. Perform an inorder traversal of the BST.
# 2. Keep track of the count of nodes visited so far.
# 3. When the count reaches k, return the value of the current node.
# 4. The kth smallest element will be the kth node visited in the inorder traversal.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # Recursive Inorder Traversal
        def inorder(root):
            # Base case
            # If we reach a leaf node or if we have already found the kth smallest element, we don't need to continue
            if not root or self.res: return
            # Traverse the left subtree
            inorder(root.left)
            # Decrement k for each node visited
            self.k -= 1
            # If k is 0, we have found the kth smallest element
            if self.k == 0: self.res = root.val
            # Traverse the right subtree
            inorder(root.right)
        # Initialize the result variable and k
        # to keep track of the count of nodes visited and the kth smallest element
        self.res = 0
        self.k = k
        # Perform the inorder traversal
        inorder(root)
        # Return the kth smallest element
        return self.res

# Recursive Approach
# Time Complexity : O(N)
# Space Complexity : O(h) + O(k)
# Approach:
# 1. Perform an inorder traversal of the BST.
# 2. In a result list, store the values of the nodes in the order they are visited.
# 3. Return the kth element from the result list.
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # Recursive Inorder Traversal
        def inorder(root):
            # Base case
            if not root: return
            # Traverse the left subtree
            inorder(root.left)
            # Append the current node's value to the result list
            self.res.append(root.val)
            # Decrement k for each node visited
            inorder(root.right)
        # Initialize the result list
        self.res = []
        # Perform the inorder traversal
        inorder(root)
        # Return the kth smallest element
        return self.res[k-1]


# Time Complexity : O(N)
# Space Complexity : O(h)
# Iterative Approach
# Approach:
# 1. Use a stack to perform an iterative inorder traversal of the BST.
# 2. Keep track of the count of nodes visited so far by decrementing k.
# 3. When k reaches 0, return the value of the current node.
# 4. The kth smallest element will be the kth node visited in the inorder traversal.
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # Initialize a stack to keep track of nodes
        stack = []
        # Perform an iterative inorder traversal
        while stack or root:
            # Traverse the left subtree
            # Push all left nodes onto the stack
            while root:
                stack.append(root)
                root = root.left
            # Pop the top node from the stack
            # This is the next node in the inorder traversal
            root = stack.pop()
            # Decrement k for each node visited
            k -= 1
            # If k is 0, we have found the kth smallest element
            if k == 0: return root.val
            # Traverse the right subtree
            # Move to the right child of the current node
            root = root.right