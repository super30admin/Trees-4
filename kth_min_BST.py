#Time Complexity: O(N)

#Space Complexity: O(H) where H is the height of the tree

class Solution:
    def __init__(self):
        self.count = 0
        self.result = -1
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return -1
        
        def inorder(root):
            if not root:
                return 
            
            inorder(root.left)
            self.count+=1
            if self.count == k:
                self.result = root.val
                return 
            inorder(root.right)
        inorder(root)
        return self.result