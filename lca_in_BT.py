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
        # Time Complexity : O(n) because we are traversing through all the elements of the tree
# Space Complexity : O(n) recursive stack

# base case
        if root == None or root == p or root == q:
        #if anything is found> return root node as answer to callstack
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        #if left and right side of same node have p and q on either sides>
        #that node is answer
        if left != None and right != None:
            return root
        #if either gave answer > that node is successor and we are ancestor
        elif left != None:
            return left
        elif right != None:
            return right
        #return  null from leaf node
        return None
    '''
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
        #O(n)
        #O(n)
        self.res=[]
        self.helper(root,p,[])
        self.helper(root,q,[])
        path1=self.res[0]
        path2=self.res[1]
        
        #make paths traversals from root to that node
        #from those two paths, find last common point> immediate ancestor
        count=0
        #run loop till minimum lebgth of either array
        for i in range(min(len(path1),len(path2))):
            if path1[i]!=path2[i]:
                break
            count=i
        return path1[count]
    
      #backtrack
    def helper(self,root,key,path):
        if not root:
            return
        #path starts with root node
        path.append(root)
        #if root is the key
        #return path 
        if root==key:
            self.res.append(path[:])
            return self.res
        #run on left
        self.helper(root.left,key,path)
        #run on right
        self.helper(root.right,key,path)
        #if last node in path is not required node> backtrack
        if path[len(path)-1]!=key:
            path.remove(path[len(path)-1])
        '''
        
        

        