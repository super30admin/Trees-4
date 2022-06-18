'''
Time Complexity: 0(k)
Space Complexity: 0(h) -- recursive stack

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.resultList = None
        self.k = None
    
    def inorderTraversal(self,currentNode):
        # base-case
        if self.k == 0:
            # stop the recursion
            return None
        
        elif currentNode == None:
            return None
        
        # logic-case
        # 1. traverse on the lhs
        lhs = self.inorderTraversal(currentNode.left) 
        if lhs != None and self.k != 0:
            self.resultList = lhs
            self.k -= 1
         
        # 2. add the currentNode i.e. root
        if self.k != 0:
            self.resultList = currentNode
            self.k -= 1
        else:
            return None
        
        # 3. traverse on the rhs
        rhs = self.inorderTraversal(currentNode.right)
        if rhs != None and self.k != 0:
            self.resultList = rhs
            self.k -= 1
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.inorderTraversal(root)
        '''
        # iterate the resultList
        for ele in self.resultList:
            print("Val is:\t",ele.val)
        '''
        return self.resultList.val