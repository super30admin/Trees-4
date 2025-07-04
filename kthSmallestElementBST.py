"""
Inorder traversal of BST to get nodes in sorted order
Go through left - root - right and count elements
When count == k, return the current node's value
"""
"""
Time Complexity - O(h + k) h is tree height
Space Complexity - O(h) for the stack
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class kthSmallestElementBST:
    def kthSmallest(self, root: 'TreeNode', k: int) -> int:
        stack = []

        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right

if __name__ == "__main__":

    root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left.right = TreeNode(2)

    obj = kthSmallestElementBST()
    print(obj.kthSmallest(root, 1))
