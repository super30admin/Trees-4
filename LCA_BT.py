'''
Solution:
1.  Using Recursion, when calling recursion on subtrees, return Null if the node is null;
    if the value of the node matches one of the p or q values => return the node itself.
2.  Otherwise, get the left Common Ancestor and right Common Ancestor using recursion, and
    check whether both are null or only one of them is null and return the appropriate node.
3.  Using Iteration, I completely replicated what happens during Recursion using a stack.

Time Complexity:    O(n) in both the cases, where n is the number of nodes.
Space Complexity:   O(h) in both the cases, where h is the height of the tree.

--- Passed all testcases successfully on Leetcode.
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LCA_BT_Iteration:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        #   edge case check
        if (root == None):
            return root
        
        #   initialize the stack
        result = None
        stack = [[root, 0, None, None]]
        
        #   iterate until the stack is empty
        #   elements inside stack => node, left LCA, right LCA, count which represents whether both
        #   left and right subtrees have been completed visiting.
        while (len(stack) > 0):
            
            #   store top node and count but don't pop without traversing left and right subtrees.
            topElement = stack[-1]
            topCount = topElement[1]
            topNode = topElement[0]
            
            #   if count is 0 => left subtree needs to be traversed.
            if (topCount == 0):
                stack[-1][1] += 1           #   update the count of current node
                #   if possible left LCA => update current node's left LCA
                if (topNode.left != None and 
                    (topNode.left.val == p.val or topNode.left.val == q.val)):
                    stack[-1][2] = topNode.left
                #   else if left node not null => push it to the stack
                elif (topNode.left != None):
                    stack.append([topNode.left, 0, None, None])
                    
            #   if count is 1 => right subtree needs to be traversed.
            elif (topCount == 1):
                stack[-1][1] += 1           #   update the count of current node
                #   if possible right LCA => update current node's right LCA
                if (topNode.right != None and 
                    (topNode.right.val == p.val or topNode.right.val == q.val)):
                    stack[-1][3] = topNode.right
                #   else if right node not null => push it to the stack
                elif (topNode.right != None):
                    stack.append([topNode.right, 0, None, None])
            
            #   if count is 2 => both left and right subtrees are done with their computations
            #   and the top node contains info about both left LCA and right LCA
            else:

                #   pop the element from stack and store all available info
                poppedElement = stack.pop()
                poppedNode = poppedElement[0]
                poppedLeftLCA = poppedElement[2]
                poppedRightLCA = poppedElement[3]
                
                #   if left LCA and right LCA are not null => return the node directly
                if (poppedLeftLCA != None and poppedRightLCA != None):
                    return poppedNode
                
                #   if this is the main root => len of stack would be 0 and so return the corresponding LCA
                #   which can be one of left LCA (if right LCA is null) or right LCA (if left LCA is null)
                #   or root itself if both LCAs are not null
                if (len(stack) == 0):
                    if (poppedLeftLCA != None and
                       not (poppedNode.val == p.val or poppedNode.val == q.val)):
                        return poppedLeftLCA
                    elif (poppedRightLCA != None and
                         not (poppedNode.val == p.val or poppedNode.val == q.val)):
                        return poppedRightLCA
                    else:
                        return poppedNode
                
                #   if this isn't the main root => a node inside the tree
                #   update LCA in left position or right position accordingly
                else:
                    if (stack[-1][1] == 1):
                        if (poppedLeftLCA != None):
                            stack[-1][2] = poppedLeftLCA
                        elif (poppedRightLCA != None):
                            stack[-1][2] = poppedRightLCA 
                    else:
                        if (poppedLeftLCA != None):
                            stack[-1][3] = poppedLeftLCA
                        elif (poppedRightLCA != None):
                            stack[-1][3] = poppedRightLCA 
                    
        
        return result


class LCA_BT_Recursion:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        #   base case
        if (root == None):
            return root
        
        #   if root matches one of p or q => return this as LCA
        if (root.val == p.val or root.val == q.val):
            return root
        
        #   compute left and right LCAs using recursion
        leftLCA = self.lowestCommonAncestor(root.left, p, q)
        rightLCA = self.lowestCommonAncestor(root.right, p, q)
        
        #   if both are not Null => current node is LCA
        if (leftLCA != None and rightLCA != None):
            return root
        
        #   if only one is not Null, then that node will be return as left or right LCA accordingly
        elif (leftLCA != None):
            return leftLCA
        
        elif (rightLCA != None):
            return rightLCA
        
        else:
            return None