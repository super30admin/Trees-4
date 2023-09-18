# Time Complexity :O(N)
# Space Complexity :O(H)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque
import copy as cp


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def helper(self,root, p, q, path):
        #base
        if(root==None):
            return 
        if(root==p):
            self.p_path+=cp.deepcopy(path)
            self.p_path.append(root)
            # return
        if(root==q):
            self.q_path+=cp.deepcopy(path)
            self.q_path.append(root)
            # return/
        #logic
        # action
        path.append(root)
        # resurse
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        # backtrack
        path.pop()


    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # if(root==None or root==p or root==q):
        #     return root
        # l=self.lowestCommonAncestor(root.left, p, q)
        # r=self.lowestCommonAncestor(root.right, p, q)

        # if(l!=None and r!=None):
        #     return root
        # elif(l!=None):
        #     return l
        # elif(r!=None):
        #     return r
        self.p_path=[]
        self.q_path=[]
        self.helper(root, p, q, [])
        # print(self.q_path, self.p_path)
        l=min(len(self.p_path), len(self.q_path))
        # print(self.p_path)
        # print(self.q_path)
        for i in range(len(self.p_path)):
            if(self.p_path[i]!=self.q_path[i]):
                break
        return self.p_path[i-1]


        