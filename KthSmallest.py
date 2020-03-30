'''
Solution:
1.  kth smallest element in a Binary Search Tree can be found using inorder traversal as it gives
    sorted order of elements. So, find the kth element in the inorder traversal.
2.  Using Iteration, consider to be a BST Iterator, where the next element would return the next
    smallest element. So, find the kth element using that Iterator.

Time Complexity:    O(k) in both the cases, as you iterate till kth element and stop
Space Complexity:   O(h) in both the cases, where h is the height of the tree
*** Time Complexity takes O(n) instead of O(k) if we don't stop at count = k ***

--- Passed all testcases successfully on Leetcode.
'''

# Definition for a binary tree node.
class TreeNode:

    #   definition of TreeNode
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class KthSmallestRecursion:
    
    #   maintain count and result variables
    def __init__(self):
        self.count = 0
        self.result = None
    
    def __helper(self, root: TreeNode, k: int):

        #   base case
        if (root == None):
            return
        
        #   left traversal
        self.__helper(root.left, k)
        
        #   computation => increment count whenever a value is traversed and when count is k
        #   assign result to the current node.
        self.count += 1
        if (self.count == k):
            self.result = root
        
        #   right traversal  
        self.__helper(root.right, k)
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        #   edge case check
        if (root == None):
            return -1
        
        #   calling helper function and returning the result
        self.__helper(root, k)
        return self.result.val

class KthSmallestIteration:
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        #   edge case check
        if (root == None):
            return -1
        
        #   initializations
        stack = []
        currNode = root
        
        #   first fill the stack till the smallest element in BST
        while (currNode != None):
            stack.append(currNode)
            currNode = currNode.left
         
        #   until the stack is empty   
        while (len(stack) > 0):

            #   pop the top Node and decrement k
            minNode = stack.pop()
            k -= 1

            #   if you hit k = 0, return the value
            if (k == 0):
                return minNode.val

            #   else place the nodes until you reach the next smallest element
            if (minNode.right != None):
                currNode = minNode.right
                while (currNode != None):
                    stack.append(currNode)
                    currNode = currNode.left
        
        return -1