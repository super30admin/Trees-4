'''
Time Complexxity: O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def preorder(root, temp):
            if(not root):
                return
            if(root.val==temp.val):
                return [root] 
            v1 = preorder(root.left, temp)
            if(v1):
                v1.append(root)
                return v1
            else:
                v2 = preorder(root.right, temp)
                if(v2):
                    v2.append(root)
                    return v2
            
        arr1 = preorder(root, p)[::-1]
        arr2 = preorder(root, q)[::-1]


        for i in range(min(len(arr1), len(arr2))):
            if(arr1[i]!=arr2[i]):
                break
            temp = arr1[i]
        return temp
        
        
        