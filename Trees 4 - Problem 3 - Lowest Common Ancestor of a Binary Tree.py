"""
FAANMG Problem #104 {Medium} 

236. Lowest Common Ancestor of a Binary Tree


Time Complexity O(N)
Space Complexity:  O(H)
        H: height of the tree
Did this code successfully run on Leetcode : Yes

Bottom Up Recursive Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # check if root is null or if we found any of p or q, then simply return the root
        if root == None or p == root or q == root:
            return root

        # maintain the left and right for each node
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # if both the left and right are null, then simply return null
        if left == None and right == None:
            return None
        
        # if left is null and right is not null, then return the value as right
        elif left == None and right != None:
            return right
        # if left is not value, and right is null, then return the value as left
        elif left != None and right == None:
            return left

        else:
        # else when both has some values, then return the root
            return root

"""
FAANMG Problem #104 {Medium} 

236. Lowest Common Ancestor of a Binary Tree


Time Complexity O(H)
Space Complexity:  O(H)
        H: height of the tree
Did this code successfully run on Leetcode : Yes

Top Down Path Approach

@name: Rahul Govindkumar_RN27JUL2022
"""
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        self.pathp = []
        self.pathq = []
        self.flagp = self.flagq = False
        if not root:
            return None

        # call the backtrack which is the helper solution 
        self.backtrack(root, p, q, [])

        # after forming the two paths for p and q, check for the common one, which is our result
        for i in range(len(self.pathp)):
            if self.pathp[i] != self.pathq[i]:
                return self.pathp[i-1]

    def backtrack(self, root, p, q, path):
        if not root:
            return
        # action
        # append the node to the path
        path.append(root)

        # if we find the p node, add the path till now to the pathp and add the current node once more to take care of the result comparison
        # also set the flag as true
        if p == root:
            self.pathp = (path[:])
            self.pathp.append(root)
            self.flagp = True
        # if we find the q node, add the path till now to the pathq and add the current node once more to take care of the result comparison
        # also set the flag as true
        if q == root:
            self.pathq = (path[:])
            self.pathq.append(root)
            self.flagq = True
        # recurse
        # only recurse if either flags is true
        if not self.flagp or not self.flagq:
            self.backtrack(root.left, p, q, path)
        if not self.flagp or not self.flagq:
            self.backtrack(root.right, p, q, path)

        # backtrack
        # remove the last added element to the path to maintain just one single list of path
        path.pop()