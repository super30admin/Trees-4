'''
Iterative:
Time Complexity: O(k)
Space Complexity: O(k)
Did this code successfully run on Leetcode : Yes
Explanation : 2 solutions recursive and iterative.
For recursive: Do inorder traversal, decrementing the k as we go, when k ==0 we got the kth value
For iterative: Create a stack. Go as left as possible to get the smaller elements.
Now go through the stack. If it has a right element then go as left as possible again. decrement k as we pop and once
k is 0 we found the kth element.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.K = 0
        self.result = 0

    def inorder(self, root):
        if root == None:
            return

        self.inorder(root.left)

        self.K -= 1

        if self.K == 0:
            self.result = root.val
            return

        self.inorder(root.right)

    def kthSmallest(self, root, k):
        self.K = k

        self.inorder(root)

        return self.result

    def kthSmallestIter(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        if root == None:
            return 0

        stack = []
        cursor = root

        # go to the left most element to get least element
        while cursor != None:
            stack.append(cursor)
            cursor = cursor.left

        while len(stack) != 0:
            cursor = stack.pop()

            k -= 1
            if k == 0:
                return cursor.val
            if cursor.right != None:
                cursor = cursor.right
                while cursor != None:
                    stack.append(cursor)
                    cursor = cursor.left

        return 0

