"""
// Time Complexity : O(k)
// Space Complexity : O(1) ignoring recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    count = 0
    result = None
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if not root: return
        self.traverse(root, k)
        return self.result
    
    def traverse(self, root, k):
        if not root: return
        
        self.traverse(root.left, k)
        
        self.count += 1
        if self.count == k:
            self.result = root.val
        
        if not self.result:
            self.traverse(root.right, k)