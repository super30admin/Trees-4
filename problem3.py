'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation : 2 solutions recursive and iterative.
For recursive:
    Go to the left of the tree as possible until we find p or q.
    If we find either return it till the LCA. If not found return None.
    Go to the right of the tree as possible until we find p or q.
    If we find either return it till the LCA.  If not found return None.
    At the LCA check if root.left is not Null and root.right is not Null if this is true then we found the LCA and
    keep returning till we reach the root of the tree and return the LCA value.
For iterative: Same as recursive except we used while loop
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        stack = [root]

        parent = {root: None}

        while p not in parent or q not in parent:
            node = stack.pop()

            if node.left != None:
                parent[node.left] = node
                stack.append(node.left)

            if node.right != None:
                parent[node.right] = node
                stack.append(node.right)

        # print(parent)
        ancestors = set()

        # print(p)
        while p != None:
            ancestors.add(p)
            p = parent[p]

        print(ancestors)
        while q not in ancestors:
            ancestors.add(q)
            q = parent[q]

        return q

    def lowestCommonAncestorRec(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        if root == None:
            return root

        # Case when p is the LCA of q ie 5,2 is 5
        if root.val == p.val or root.val == q.val:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left != None and right != None:
            return root
        elif left != None:
            return left
        elif right != None:
            return right

        return None