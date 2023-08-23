#TC - O(N)
#SC - O(N)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        l=[]
        def dfs(root):
            if root:
                dfs(root.left)
                l.append(root.val)
                dfs(root.right)
        dfs(root)
        return l[k-1]

        

            
      