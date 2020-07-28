# Time Complexity : Add - O(log N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a global counter and do an inorder traversal.
2. Increase the count everytime a root is popped out, while also checkinh if k==count
3. When it is we have found the element
'''
class Solution:
    result = None
    count = 0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.count = 0
        self.result = -1
        self._helper(root,k)
        return self.result
        
    def _helper(self, root, k):
        
        if root is None:
            return
        
        self._helper(root.left, k)
        
        self.count += 1   
        if self.count == k:
            self.result = root.val
            return
        self._helper(root.right, k)
            
        