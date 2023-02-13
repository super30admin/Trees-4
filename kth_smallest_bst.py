#Time Complexity : O(h+k), where h is height of tree
#Space Complexity : O(h)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def kthSmallest(self, root, k):
        stack = []
        
        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if not k:
                return root.val
            root = root.right
