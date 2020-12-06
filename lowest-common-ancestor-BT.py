# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #         def backtrack(root,l,path):
        #             # base
        #             # print(l)
        #             if root==None:
        #                 return
        #             if l==root:
        #                 path.append(root)
        #                 return
        # #             recurse
        #             path.append(root)
        #             backtrack(root.left,l,path)
        #             if path[len(path)-1]==l:
        #                 return
        #             backtrack(root.right,l,path)
        #             if path[len(path)-1]==l:
        #                 return
        #             path.pop(len(path)-1)

        #         path1=[]

        #         backtrack(root,p,path1)
        #         # print('path1',path1)
        #         path2=[]

        #         backtrack(root,q,path2)
        #         # print('path2',path2)
        #         while len(path1)<len(path2):
        #             path1.append(0)
        #         while len(path1)>len(path2):
        #             path2.append(0)
        #         for i in range(len(path2)):

        #             if path1[i]!=path2[i]:
        #                 return path1[i-1]
        #             #time-O(2n)-if the p,q value is rightmost last element #space-O(h)
        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        if not left:
            return right
        if not right:
            return left
        # time-O(n) and space-O(h) which is also O(n) in skewed binary tree