# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Iterative TC - O(h+k)
        # SC - O(h)
        stack = []
        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right

    '''
        # Recursive 
        #TC = O(k) we do inorder traversal on k elements only worst case k == n then TC = O(n)
        # SC = O(k)
        def inorder(root):
            #base
            if not root:
                return None
            #logic
            if len(result) < k:
                inorder(root.left)
                if len(result) < k:
                    result.append(root.val)
                inorder(root.right)

        result = []
        inorder(root)
        return result[-1]
    '''

    ''' 
        # Not working
        count = 0
        def inorder(root,k):
            global count 
            #base
            if not root:
                return None
            #logic
            inorder(root.left,k);
            count += 1
            if k == count:
                return root.val

            inorder(root.right,k)

        result = inorder(root,k)
        return result
    '''