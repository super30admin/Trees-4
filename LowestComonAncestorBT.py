#236. Lowest Common Ancestor of a Binary Tree
"""
Time Complexity : O(n)
Space Complexity : O(height of tree)

Storing path for p and q and then comparing them to find node at which paths 
are going different.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    path_p = []
    path_q = []
    def helper(self, root, p, q, temp):
        #base
        if root == None:
            return
        
        if root == p:
            t = temp
            t.append(p)
            self.path_p.append(list(t))
            t.pop()
            #return
            
        if root == q:
            t = temp
            t.append(q)
            self.path_q.append(list(t))
            t.pop()
            #return
        
        #logic
        temp.append(root)
        self.helper(root.left, p, q, temp)
        temp.pop()
        
        temp.append(root)
        self.helper(root.right, p, q, temp)
        temp.pop()
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        self.path_p = []
        self.path_q = []
        
        temp = list()
        self.helper(root, p, q, [])
        
        #print(self.path_p[0])
        
        #print(self.path_q[0])
        
        i = 0
        j = 0
        result = None
        
        #now we just have to find least common root elment from both paths
        if len(self.path_p[0]) < len(self.path_q[0]):
            self.path_p, self.path_q = self.path_q, self.path_p
        
        for i in range(0, len(self.path_q[0])):
              #print(self.path_p[0][i].val, self.path_q[0][i].val)
            if self.path_p[0][i].val == self.path_q[0][i].val:
                pass

            else:
                result = self.path_q[0][i-1]

                break

        if result == None:
            #print("here")
            result = self.path_q[0][ len(self.path_q[0]) - 1]

        #print(result)
        #print(result.val)

        return result
