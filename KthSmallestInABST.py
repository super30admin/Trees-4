# Time Complexity : O(k + h) where h is the height
# Space Complexity : O(h)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.result = None
        self.count = 0

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.result = -1
        self.inorder(root, k)
        return self.result

    def inorder(self, root: TreeNode, k):
        # Base
        if root == None:
            return
        # logic
        self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
        self.inorder(root.right, k)

#Iterative Approach

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while root or stack:
            while root :
                stack.append(root)
                root = root.left
            root = stack.pop()
            k-=1
            if k == 0:
                return root.val
            root = root.right
        return -1