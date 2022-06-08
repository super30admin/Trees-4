#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return root
        n=0
        curr = root
        stack = [root]
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            
            curr = stack.pop()
            n +=1
            if n==k:
                return curr.val
            curr = curr.right
            
#Recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def recursive(root):
            if not root:
                return None
            recursive(root.left)
            self.num += 1
            if self.num==k:
                self.fin = root.val
            recursive(root.right)
        
        self.num = 0
        self.fin = 0
        recursive(root)
        return self.fin