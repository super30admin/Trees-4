# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     self.plist=None
    #     self.qlist=None
    #     self.dfs(root,p,q,[])
    #     for i in range(len(self.plist)):
    #         if self.plist[i]!=self.qlist[i]:
    #             return self.plist[i-1]  
    # def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode',path:List['TreeNode']):
    #     if root==None: return
    #     path.append(root)
    #     if root==p:
    #         self.plist=path.copy()
    #         self.plist.append(p)
    #     if root==q:
    #         self.qlist=path.copy()
    #         self.qlist.append(q)  
    #     self.dfs(root.left,p,q,path)
    #     self.dfs(root.right,p,q,path)
    #     path.pop()
    # Time Complexity: O(n)
    # Space Complexity: O(h)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root==None or root==p or root==q: return root
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        if left==None and right==None: return None
        if left==None and right!=None: return right
        if left!=None and right==None: return left
        if left!=None and right!=None: return root