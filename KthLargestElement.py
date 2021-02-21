# TC: O(k)
# SC: O(h)
# Inorder traversal
# Iterative
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root: return None
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root.right
                
# Recursive
class Solution:
    result = None
    count = 0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root: return None
        self.helper(root, k)
        return self.result
    
    def helper(self, root, k):
        # base
        if root != None:
            print(root.val)
        if root == None:
            return
        # logic
        self.helper(root.left, k)
        self.count += 1
        if k == self.count:
            self.result = root.val
            return
        # small optimization
        if self.result == None:
            self.helper(root.right, k)