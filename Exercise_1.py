#Time Complexity : O(N)), N being the number of values in tree. 
#Space Complexity : O(h), h being the height of the tree. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Forgot can use the constructor to save values. 
#Your code here along with comments explaining your approach in three sentences only
'''Use in order traversal and a counter in the constructor. If counter equals k, save the 
root value into result in constructor. Return result in the end. 
'''
class Solution:
    def __init__(self):
        self.result = -1
        self.count = 0
        self.k = -1
    def helper(self, root):
        if root:
            self.helper(root.left)
            self.count = self.count+1
            if self.count==self.k:
                self.result = root.val
            self.helper(root.right)   

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.helper(root)
        return self.result