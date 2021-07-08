# TC: O(K) since we will be not be traversing elements greater than K elements. 
# SC: O(H) where H is the size of the recursive stack.

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.count = 0
        self.result = -1
        def inorder(root, k): 
#             base
            if not root: 
                return
        
#             logic
            inorder(root.left, k)
            self.count += 1
            if self.count == k:
                self.result = root.val
            
            if self.result == -1: 
                inorder(root.right, k)
            
        inorder(root, k)
        return self.result
