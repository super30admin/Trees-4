# // Time Complexity : O(k+h) 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count=k
        self.flag=False
        self.res=None
        self.inorder(root)
        return self.res
    
        
    def inorder(self, root):
        if not root:
            return 
        if not self.flag:
            self.inorder(root.left)
        self.count-=1
        if self.count==0:
            self.flag=True
            self.res=root.val
            return
        if not self.flag:
            self.inorder(root.right)