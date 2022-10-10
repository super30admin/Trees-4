# Time Complexity: O(h)
# Space Complexity: O(1)

# ----------------------------------------Iterative Approach------------------------------------
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root is None: return None
        stack = []
        count = k
        
        while stack or root:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            count -= 1
            if count == 0:
                return root.val
            root = root.right

# ----------------------------------------Recursive Approach------------------------------------
class Solution:
    def __init__(self):
        self.count = 0
        self.result = 0
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root is None: 
            return None
        self.count = k
        
        self.helper(root)
        return self.result
    
    def helper(self, root):
        #base
        if root is None: return

        #logic
        self.helper(root.left)
        self.count -= 1
        print(root.val)
        
        if self.count == 0:
            self.result = root.val
        self.helper(root.right)