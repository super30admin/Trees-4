# Trees-4

## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return -1
        self.count = 0
        self.answer = -1
        self.inorder(root, k)
        return self.answer
    
    def inorder(self,root: Optional[TreeNode], k: int) -> None:
        if root == None:
            return 
        self.inorder(root.left,k)
        self.count = self.count +1
        if self.count == k:
            self.answer = root.val
            return

        self.inorder(root.right,k)

#TC = O(n), SC =O(h)

## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return 
        return self.dfs(root, p, q)

    def dfs(self,root: 'TreeNode', p:'TreeNode', q:'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        if root.val < p.val and root.val < q.val:
            return self.dfs(root.right, p, q)
        elif root.val > p.val and root.val > q.val:
            return self.dfs(root.left, p , q)
        else:
            return root

#TC = O(h); SC = O(h) where h = height of the binary serach tree

## Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        self.pathP = []
        self.pathQ = []
        self.dfs(root, p, q, [])
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                break
        return self.pathP[i-1]    
    
    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', path:  List[int]) -> 'TreeNode':
        #base
        if root == None:
            return
        path.append(root)
        if root == p:
            self.pathP = [element for element in path]
            self.pathP.append(root)
        if root == q:
            self.pathQ = [element for element in path]
            self.pathQ.append(root)
        self.dfs(root.left, p, q, path)
        self.dfs(root.right, p, q, path)
        path.pop()

# TC = O(n); SC = O(h)