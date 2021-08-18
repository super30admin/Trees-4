# // Time Complexity : O(n)
# // Space Complexity : O(n)

#Recursive Approach
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        path1 = []
        path2 = []
        self.helper(root, p, path1)
        self.helper(root, q, path2)
        for i in range(len(path1)):
            if path1[i] != path2[i]:
                return path1[i - 1]
        return None

    def helper(self, root, p, path):
        # BAse
        if root == None:
            return
        if root == p:
            path.append(root)
            path.append(root)
            return
        # logic
        # action
        path.append(root)

        # recurse
        self.helper(root.left, p, path)
        self.helper(root.right, p, path)

        if path[len(path) - 1] == p:
            return
        # backtrack
        path.pop()

# // Time Complexity : O(n)
# // Space Complexity : O(n)

#Approach 2
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base
        if root == None or root == p or root == q:
            return root

        #logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left != None and right != None:
            return root
        elif left != None:
            return left
        elif right != None:
            return right
        else:
            return None