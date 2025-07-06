# TC: O(n)
# SC: O(h), h is height of tree
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res=0
        def helper(root):
            nonlocal k,res
            #base
            if not root:
                return
            #logic
            helper(root.left)
            k-=1
            if k==0:
                res=root.val
            
            helper(root.right)

        helper(root)
        return res
                
