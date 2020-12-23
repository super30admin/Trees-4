class Solution:
# O(n) spc and tc
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        def in_order(root, k):
            if root == None:
                return []
            
            in_left=in_order(root.left,k-1)
            root_val=[root.val]
            in_right=in_order(root.right,k-1)
            return in_left+root_val+in_right
        
        return in_order(root,k)[k-1]
