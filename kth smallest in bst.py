# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def kthSmallest(self, root, k):
        
        # recursively add elements to list using inorder traversal
        def inorder(r):
            return inorder(r.left) + [r.val] + inorder(r.right) if r else []
        
        # return the kth index from the list
        return inorder(root) [k-1]