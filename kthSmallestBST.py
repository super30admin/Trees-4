#Time Complexity: O(n)
#Space Complexity: O(h)
class Solution:
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.curr = TreeNode()
        self.helper(root)
        return self.curr.val
            
    def helper(self,root):
        if not root:
            return
        
        self.helper(root.left)
        self.count -=1 
        if self.count == 0:
            self.curr = root
        self.helper(root.right)
        