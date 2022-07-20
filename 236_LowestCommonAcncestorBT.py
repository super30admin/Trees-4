# DFS and backtrack
# Time Complexity : O(n)
# Space Complexity: O(h)

# DFS and bottom up
# Time Complexity : O(n)
# Space Complexity: O(1)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # DFS and backtrack
    # take two path for q and p
    # check in both path, when first diffrent node will come, return the previous node
    # that node become lowest common ancestor
    pathP = []
    pathQ = []
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return None
        # pathP = self.pathP
        # pathQ = self.pathQ
        self.helper(root,p,q,[])
        for i in range(0,len(self.pathP)): #pathQ can also use as range, because we need to check until diffrent node will come 
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]
        return None
    
    def helper(self,root,p,q,path):
        #base
        if root == None:
            return
        path.append(root)
        if root == p:
            self.pathP = path.copy()
            self.pathP.append(p)
        if root == q:
            self.pathQ = path.copy()
            self.pathQ.append(q)
        
        #recurse
        self.helper(root.left,p,q,path)
        self.helper(root.right,p,q,path)
        #backtrack
        path.pop(len(path)-1)
        

    # bottom up approach, DFS
    
    def lowestCommonAncestor2(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    # we find p and q
    # ex , root = [3,5,1,6,2,0,8,null,null,7,4], p = 7, q = 8
    #                               3
    #                           /        \
    #                          5           1
    #                        /   \        /  \
    #                      6      2      0    8
    #                            / \
    #                           7   4
    # we will do DFS, when we find Null to at child, we return Null to it's parent at that side
    # in this example, when we are at 6, we found null to it's both side and did'nt find p or q, so we return Null to 5
    # now we do DFS to right of 5
    # at left side of the 2 we found 7(p), so we return 7 to the 2 and go right side.
    # at right we found 4->null. so we return null to the 2 
    # so here at 2 we got 7 and null, so we return 7 to the 5 and from 5 ->
    # go right side of the 3
    # same way we found 8.
    # so at 3, we got both. so ancestor is 3

        # if one of the element is root, than lowest ancestor is that root.
        if root == None or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        if left == None and right == None:
            return None
        elif left == None and right != None:
            return right
        elif left != None and right == None:
            return left
        return root