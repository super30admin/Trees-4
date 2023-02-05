# TC: O(n)
# SC: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # Recursive
    # TC: O(n)
    # SC: O(h)
    # Since a BST has the property that the indorder traversal would be sorted
    # so the kth element in the indorder traversal would be the Answer

    def __init__(self):
        self.count = 0
        self.result = -1

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root is None:
            return None

        self.dfs(root,k)
        return self.result

    def dfs(self,root,k):
        if root is None:
            return

        if self.result==-1:
            self.dfs(root.left,k)

        self.count+=1
        if self.count==k:
            self.result = root.val
            return

        if self.result==-1:
            self.dfs(root.right,k)

    # # Iterative
    # def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    #     if root is None:
    #         return None
    #     count = 0
    #     result = -1
    #     stack = list()
    #     stack.append(root)

    #     while((root is not None) or (len(stack)!=0)):
    #         while(root is not None):
    #             stack.append(root)
    #             root = root.left

    #         root = stack.pop()
    #         count+=1
    #         if count==k:
    #             return root.val

    #         root = root.right

    #     return result