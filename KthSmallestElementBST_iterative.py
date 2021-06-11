# TC: O(N) since in worst case, we would be traversing all the nodes of the BST. 
# SC: O(H) where H is the height of the stack being used.

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root: 
            return
        
        stack = []
        count = 0
        while root or stack: 
            while root:
                stack.append(root)
                root = root.left
            
            curr = stack.pop()
            count += 1
            if count == k: 
                return curr.val
            
            root = curr.right
        
        return -1
        
