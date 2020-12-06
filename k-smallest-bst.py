# Definition for a binary tree node.

# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# follow-up- if it were a binary tree use prioirty
# queue for sorting and searching whose time complexity will be decreased from O(nlogn) to O(nlogk)
class Solution(object):
    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        self.k -= 1
        if self.k == 0:
            self.res = root.val
            print(self.res)
            return

        self.inorder(root.right)

    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.res = None
        self.k = k
        self.inorder(root)
        return self.res
    # time-O(h+k)->max of h and k(for k=1 we have to traverse till the end(root.left)) space-O(height)

    # stack=[]
    # i=0
    # while stack or root:
    #     while root:
    #         stack.append(root)
    #         root=root.left
    #     i+=1
    #     popped=stack.pop()
    #     if i==k:
    #         return popped.val
    #     root=popped.right
    # return None