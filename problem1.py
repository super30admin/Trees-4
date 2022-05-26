#Problem1 Kth Smallest Element in a BST
# // Time Complexity :  O(N)
# // Space Complexity : O(H) - height of the tree, recursive stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count=k
        self.res=0
        self.found=False
        def dfs(root):
            if(root==None ):
                return
            
            if(not self.found):
                dfs(root.left)
            self.count-=1
            if self.count==0:
                self.res=root.val
                self.found=True
                return
            if (not self.found):
                dfs(root.right)
        dfs(root)
        return self.res