#TC: O(k)
#SC: O(h)

class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class KthSmallestRecursion:
    
    def __init__(self):
        self.count = 0
        self.result = None
    
    def __helper(self, root: TreeNode, k: int):

        if (root == None):
            return
        
        self.__helper(root.left, k)
        
        self.count += 1
        if (self.count == k):
            self.result = root
        
        self.__helper(root.right, k)
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if (root == None):
            return -1
        
        self.__helper(root, k)
        return self.result.val

class KthSmallestIteration:
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if (root == None):
            return -1
        
        stack = []
        currNode = root
        
        while (currNode != None):
            stack.append(currNode)
            currNode = currNode.left
          
        while (len(stack) > 0):

            minNode = stack.pop()
            k -= 1

            if (k == 0):
                return minNode.val

            if (minNode.right != None):
                currNode = minNode.right
                while (currNode != None):
                    stack.append(currNode)
                    currNode = currNode.left
        
        return -1