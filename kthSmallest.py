# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Time Complexity: O(N)
    Space Complexity: O(h)
    """
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        count = 0
        while stack or root !=None:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            count += 1
            if count ==k:
                return root.val
            root = root.right
        return -1

###################### Using recursion ##############
class Solution:
    """
    Time Complexity: O(N)
    Space Complexity: O(h)
    """
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = None
        self.dfs(root,k)
        return self.result
    def dfs(self,root: Optional[TreeNode], k: int) -> None:
        if root == None:
            return
        self.dfs(root.left, k)
        self.count +=1
        if self.count == k:
            self.result = root.val
            return 
        self.dfs(root.right,k)





        
