class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        def helper(root,res):
            if root==None:
                return
            helper(root.left,res)
            res.append(root.val)
            helper(root.right,res)
        res=[]
        helper(root,res)
        return res[k-1]
#Time-complexity: O(N)
#space-complexity: O(H)