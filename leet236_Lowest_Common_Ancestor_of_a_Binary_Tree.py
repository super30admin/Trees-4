# Solution

# // Time Complexity : Second Approach O(n)  we might end up looking at all the nodes
#                       First Approach O(n) we might end up looking at all the nodes
# // Space Complexity : Second Approach O(1) we are not 
#                       First Approach O(n) since we will be using list to save paths 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# DFS should be done and we need to keep recording the path we are travelling, when we reach one of the numbers either p or q
# we should record the path we travelled. Once we save both paths related to p and q, last element which is common between both
# paths will be the result node

# This does not run since I have not worked on creating the BST part instead just wrote the solution

def lowestCommonAncestor(root,p,q):
    left = None
    right = None
    if root == None or root.val == p.val or root.val == q.val:
        return root
    
    left = lowestCommonAncestor(root.left,p,q)
    right = lowestCommonAncestor(root.right,p,q)

    if left == None and right == None:
        return None
    elif left != None and right == None:
        return left
    elif left == None and right != None:
        return right
    else:
        return root

# def lowestCommonAncestor(root,p,q):
#     pathP = []
#     pathQ = []
#     if p.val == root.val or q.val == root.val:
#         return root
    
#     helper(root,p,q,[],pathP,pathQ)
#     n = min(len(pathP[0]),len(pathQ[0]))
#     for i in range(0,n):
#         nodeP = pathP[0][i]
#         nodeQ = pathQ[0][i]
#         if nodeP != nodeQ:
#             return pathP[0][i-1]
    
#     return None
    
# def helper(root,p,q,path,pathP,pathQ):
#     if root == None:
#         return
#     path.append(root)
#     if root.val == p.val:
#         path.append(root)
#         pathP.append(path.copy())
#         path.pop()
        
#     if root.val == q.val:
#         path.append(root)
#         pathQ.append(path.copy())
#         path.pop()
    
#     helper(root.left,p,q,path,pathP,pathQ)
#     helper(root.right,p,q,path,pathP,pathQ)
#     path.pop()