#TC: O(n)
#SC: O(h)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LCA_BT_Iteration:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if (root == None):
            return root
        
        result = None
        stack = [[root, 0, None, None]]
        
        while (len(stack) > 0):
            
            topElement = stack[-1]
            topCount = topElement[1]
            topNode = topElement[0]
            
            if (topCount == 0):
                stack[-1][1] += 1           
                if (topNode.left != None and 
                    (topNode.left.val == p.val or topNode.left.val == q.val)):
                    stack[-1][2] = topNode.left
                elif (topNode.left != None):
                    stack.append([topNode.left, 0, None, None])
                    
            elif (topCount == 1):
                stack[-1][1] += 1          
                if (topNode.right != None and 
                    (topNode.right.val == p.val or topNode.right.val == q.val)):
                    stack[-1][3] = topNode.right
                elif (topNode.right != None):
                    stack.append([topNode.right, 0, None, None])
            
            else:

                poppedElement = stack.pop()
                poppedNode = poppedElement[0]
                poppedLeftLCA = poppedElement[2]
                poppedRightLCA = poppedElement[3]
                
                if (poppedLeftLCA != None and poppedRightLCA != None):
                    return poppedNode
                
                if (len(stack) == 0):
                    if (poppedLeftLCA != None and
                       not (poppedNode.val == p.val or poppedNode.val == q.val)):
                        return poppedLeftLCA
                    elif (poppedRightLCA != None and
                         not (poppedNode.val == p.val or poppedNode.val == q.val)):
                        return poppedRightLCA
                    else:
                        return poppedNode
                
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
        
        if (root == None):
            return root
        
        if (root.val == p.val or root.val == q.val):
            return root
        
        leftLCA = self.lowestCommonAncestor(root.left, p, q)
        rightLCA = self.lowestCommonAncestor(root.right, p, q)
        
        if (leftLCA != None and rightLCA != None):
            return root
        
        elif (leftLCA != None):
            return leftLCA
        
        elif (rightLCA != None):
            return rightLCA
        
        else:
            return None