'''
Time Complexity: 0(n) -- all the nodes
Space Complexity: 0(n) -- storing the ele in the paths-list 
                  0(h) --- recursion stack
Run On LeetCode: Yes
Top Down Recursion
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def __init__(self):
        self.path_p = None # [3,5,6]
        self.path_q = None
    
    def bfsTraversal(self,currentNode,p,q,pathList=[]):
        # base-case
        if currentNode == None:
            return
        
        # logic-case
        # add the currentNode.val to the pathList
        
        # action
        pathList.append(currentNode)
        
        # 2. chk for cases
        # 2.1. Case 1: equal to p, not equal to q
        if currentNode == p and currentNode != q:
            
            # copy the pathList into path_p
            self.path_p = pathList[:]
            
        # 2.2. Case 2: not equal to p, equal to q
        elif currentNode != p and currentNode == q:
            
            # copy the pathList into path_q
            self.path_q = pathList[:]
            
        '''also for case currentNode != p and currentNode != q '''
        '''To Stop the recursion'''
        if self.path_p != None and self.path_q != None:
            #backtrack
            pathList.pop()
            
            # stop the recursion
            return
        
        # recurse on lhs
        self.bfsTraversal(currentNode.left,p,q,pathList)
            
        # recurse on rhs
        self.bfsTraversal(currentNode.right,p,q,pathList)
        
        #backtrack
        pathList.pop()
        
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        
        self.bfsTraversal(root,p,q)
        
        '''compare both the list and return index-1 if we get the disjoint'''
        for i in range(0,
                       max(len(self.path_p),
                             len(self.path_q))
                      ):
            
            # get ptr_p
            ptr_p = None
            if i >= len(self.path_p):
                ptr_p = float('inf')
            else:
                ptr_p = self.path_p[i]
            
            # get ptr_q
            ptr_q = None
            if i >= len(self.path_q):
                ptr_q = float('inf')
            else:
                ptr_q = self.path_q[i]
                
            
            # compare ptr_p and ptr_q
            if ptr_p != ptr_q:
                return self.path_p[i-1]
            
                
        