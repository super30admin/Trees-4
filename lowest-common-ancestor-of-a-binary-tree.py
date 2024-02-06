# Approach (DFS) - Record paths for p and q from root. Backtrack and pop all the leaf nodes from the path.
# As we have pathP = [3,5] pathQ = [3,1]. We will check two arrays and if at 'i' the elements are different,
# We return i-1 element as it will be LCA.
# Since two paths can be of different length, we add root twice so that we dont run out of array.
# pathP = [3,5,5], pathQ = [3,1,1], we return 3

# TC - O(N), SC - O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.pathP = []
        self.pathQ = []
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':


        self.backtrack(root, p, q, path)
        # I have the paths
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]

        return None
    
    def backtrack(self, root, p, q, path):
        # base
        if not root: return 
        # action
        path.append(root)
        if root == p:
            self.pathP = path[:]
            self.pathP.append(root)
        if root == q:
            self.pathQ = path[:]
            self.pathQ.append(root)
        # traverse
        self.backtrack (root.left, p ,q, path.copy())
        self.backtrack (root.right, p ,q, path.copy())
        # backtrack
        path.pop()

        


        