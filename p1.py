# Time Complexity : max (O(k), O(h+k))
# Space Complexity : O(h) 
# This is basically controlled inorder iterative solution. Whenever k reaches 0, we return the current root.
# Inorder traversal    
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left 
            
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
        return -1
