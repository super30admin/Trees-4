#Time Complexity: O(n)
#Space Complexity: O(h) h-height of the tree

class Solution:
    def __init__(self):
        self.k = 0
        self.res = None
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.recurse(root,k)
        return self.res
    def recurse(self,root,k):
        if root is None:
            return
        self.recurse(root.left,k)
        self.k+=1
        if self.k==k:
            self.res = root.val
            return 
        self.recurse(root.right,k)
        