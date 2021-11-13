# Recursive Solution
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.result = -1
        self.count = 0
        if root == None:
            return self.result
        self.inorder(root, k)
        return self.result
    
    def inorder(self, root: Optional[TreeNode], k: int):
        if root == None:
            return None
        if self.result == -1:
            self.inorder(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        if self.result == -1:
            self.inorder(root.right, k)
# Time Complexity: O(n)
# Space Complexity: O(n) - Recursive Stack space


# Iterative Solution
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return None
        stack = deque()
        while root != None or len(stack):
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        return -1
# Time Complexity: O(n)
# Space Complexity: O(n) - Stack space