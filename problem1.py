# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BruteForceSolution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        inorder = []

        def dfs(root):
            if not root:
                return
            
            dfs(root.left)
            inorder.append(root.val)
            dfs(root.right)
        
        dfs(root)
        return inorder[k-1]
    
# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class DFSSpaceOptimizedSolution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        inorder = []
        count = [k]
        res = [None]

        def dfs(root):
            if not root:
                return
            
            dfs(root.left)
            count[0] -= 1
            if count[0] == 0:
                res[0] = root.val
            dfs(root.right)
        
        dfs(root)
        return res[0]

# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class ConditionalRecursionSolution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        inorder = []
        count = [k]
        res = [None]

        flag = [False]

        def dfs(root):
            if not root:
                return
            
            dfs(root.left)
            count[0] -= 1
            if count[0] == 0:
                res[0] = root.val
                flag[0] = True
            if not flag[0]:
                dfs(root.right)
        
        dfs(root)
        return res[0]