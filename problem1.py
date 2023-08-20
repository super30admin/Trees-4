# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res = []
        self.helper(root,k)
        return self.res[k-1]


    def helper(self, root, k):
        if root == None: return 0

        self.helper(root.left,k)
        self.res.append(root.val)
        self.helper(root.right,k)



        