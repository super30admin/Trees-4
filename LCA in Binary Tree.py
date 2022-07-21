# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None



# Time Complexity: O(n)
# Space Complexity: O(1)
#bottom up approach
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root==None or root==p or root==q: return root
        
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        if left==None and right==None: return None
        elif left==None and right!=None: return right
        elif left!=None and right==None: return left
        else: return root

#dfs approach
# Time Complexity: O(n)
# Space Complexity: O(h)
'''

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root==None: return None
        self.ppath=[]
        self.qpath=[]
        def dfs(root,p,q,path):
            #base
            if root==None: return 
            
            #action
            path.append(root)
            
            #logic
            if root==p: 
                self.ppath=path[:]
                self.ppath.append(p)
            if root==q: 
                self.qpath=path[:]
                self.qpath.append(q)
            #recursion
            dfs(root.left,p,q,path)
            dfs(root.right,p,q,path)
            #backtracking
            path.pop()
            
        dfs(root,p,q,[])
        print(self.ppath)
        print(self.qpath)
        for i in range(len(self.ppath)):
            if self.ppath[i]!=self.qpath[i]:
                return self.ppath[i-1]
'''