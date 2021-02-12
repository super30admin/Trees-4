# Time complexity - O(k+h) where h:height of the tree 
# Space Complexity: O(h) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Iterative method - traverse to the left side as we are searching for kth smallest in the BST and decrement k to reach the appropriate node.

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if root is None:
            return -1
        
        stack =[]
        while root is not None or len(stack)>0:
            
            while root is not None:
                stack.append(root)
                root=root.left
            
            root = stack.pop()
            k-=1
            if k==0:
                return root.val
            root = root.right
        
        return -1
        
        
        