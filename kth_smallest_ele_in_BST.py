#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def __init__(self):
        self.result = 0
        self.count =  0
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.inorder(root)
        return self.result
    
    def inorder(self, root):
        if root == None: 
            return
        self.inorder(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root.val
            return
        self.inorder(root.right)
