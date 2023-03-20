#Time COmplexity :- O(h) if tree is fully on left sided
# Space Complexity :- O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    count = 0
    result = -1
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = -1
        if root is None:
            return -1
        
        self.dfs(root, k)
        return self.result
    
    def dfs(self,root, k):
        if root is None:
            return
        if self.result == -1:
            self.dfs(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        if self.result == -1:
            self.dfs(root.right, k)



#Iterative Approach :
# Time Complexity :- O(h)
#Space Complexity :- O(h)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        result = -1
        stack = []

        while len(stack) > 0 or root is not None:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            count +=1
            if count == k:
                return root.val
            root = root.right
        return result