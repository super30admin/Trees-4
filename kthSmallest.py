class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        '''
        Time complexity = O(N)
        Space Complexity = O(1)
        '''
        def inorder(root, k ):
            nonlocal result 
            nonlocal i 
            if not root:
                return 
            inorder(root.left, k  )
            i += 1
            if i == k :
                result = root.val
            inorder(root.right, k )
        result = None
        i = 0 
        inorder(root , k)
        return result
