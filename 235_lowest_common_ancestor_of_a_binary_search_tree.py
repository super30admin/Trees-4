"""
Leetcode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Algo:
    1. Start traversing the tree from the root node.
    2. If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
    3. If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
    4. If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees.
        and hence we return this common node as the LCA.
"""

# Approach 1: Recursive Approach
# Time Complexity: O(N), where N is the number of nodes in the BST.
#   In the worst case we might be visiting all the nodes of the BST.
# Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack
#   would be N since the height of a skewed BST could be N.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # value of current node or parent node
        parentVal = root.val

        # value of p
        pVal = p.val

        # value of q
        qVal = q.val

        # if both p and q are greater than parent
        if pVal > parentVal and qVal > parentVal:
            return self.lowestCommonAncestor(root.right, p, q)

        # if both p and q are lesser than parent
        elif pVal < parentVal and qVal < parentVal:
            return self.lowestCommonAncestor(root.left, p, q)

        # we have found the split point i.e. the LCA node
        else:
            return root


# Approach 2: Iterative Approach
# Time Complexity : O(N), where N is the number of nodes in the BST. In the worst case we might
#   be visiting all the nodes of the BST.
# Space Complexity : O(1). without using a stack or recursion since we don't need to backtrace to find the LCA node.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # value of p
        pVal = p.val

        # value of q
        qVal = q.val

        # start from the root node of the tree
        node = root

        # Traverse the tree
        while node:
            # value of current node or parent node
            parentVal = node.val

            # if both p and q are greater than parent
            if pVal > parentVal and qVal > parentVal:
                node = node.right

            # if both p and q are lesser than parent
            elif pVal < parentVal and qVal < parentVal:
                node = node.left

            # we have found the split point i.e. the LCA node
            else:
                return node

        # in case p or q does not exist in the BST.
        return None
