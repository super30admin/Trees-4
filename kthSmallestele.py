# Time Complexity : O(k+h)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:

        self.count=0
        self.result = -1
        self.inorder(root,k)
        return self.result
    
    def inorder(self,root,k):
        if root==None:
            return
        
        self.inorder(root.left,k)
        #st.pop()
        self.count+=1
        if self.count==k:
            self.result = root.val
        self.inorder(root.right,k)