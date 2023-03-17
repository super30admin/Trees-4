# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#All TC passed on leetcode

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':


        #Here we use bottom up recurrsion. We return the values from child to parent. If p or q are found then they are returned to parent else None is returned. Based on the returned values further values are returned to above parents till we reach back to the root.
        #Time complexity - O(n) - we may traverse to all nodes of tree
        #Space complexity - O(h) - stack space can go max to height of tree

        def helper(root, p, q):
            if not root:
                return None
            if root==p or root==q:
                return root

            left = helper(root.left, p, q)
            right = helper(root.right, p, q)

            if not left and not right:
                return None
            elif not left and right:
                return right
            elif left and not right:
                return left
            else:
                return root
            
        return helper(root, p, q)


#-------------------------------------------OR----------------------------------------------------
        

        #Here we use dfs backtrack. We get the paths for both p and q nodes. Then we compare the paths of p and q. At any point i where the path becomes unequal then we return the i-1th value.
        #Time complexity - O(n) - we may traverse to all nodes of tree
        #Space complexity - O(h) - path size can go max to height of tree
        pathP = []
        pathQ = []

        def helper(root, p, q, path):
            if not root:
                return
            
            path.append(root)
            if root==p:
                pathP.extend(path.copy())
            
            if root==q:
                pathQ.extend(path.copy())

            helper(root.left, p, q, path)
            helper(root.right, p, q, path)
            path.pop()
            
        
        helper(root, p, q, [])

        
        if len(pathP)<len(pathQ):
            for i in range(len(pathP)):
                if pathP[i].val!=pathQ[i].val:
                    return pathP[i-1]
                if i==len(pathP)-1:
                    return pathP[i]
        else:
            for i in range(len(pathQ)):
                print(pathP[i].val)
                print(pathQ[i].val)
                if pathP[i].val!=pathQ[i].val:
                    return pathQ[i-1]
                if i==len(pathQ)-1:
                    return pathQ[i]
        


        