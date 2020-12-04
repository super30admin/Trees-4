# Time Complexity: O(N)
# Space Complexity: O(N)
# Approach: Bottom up DFS. Every node returns information to it's parent nodes if p/q is found in the the node's subtrees or if the node is p/q itself. More comments in-line.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # Bottom Up DFS
        # Initialize LCA to None
        LCA = [None]

        def dfs(node, p, q):
            # Local booleans pFound & qFound - return values
            pFound, qFound = False, False

            # If the current node is p or q, set respective boolean
            if node is p:
                pFound = True
            if node is q:
                qFound = True
            # DFS returns if p or q is found in the subordinate/child nodes
            if node.left:
                pf, qf = dfs(node.left, p, q)
                # Check if p or q is already found in the left subtree
                # Update local pFound/qFound
                pFound = pf or pFound
                qFound = qf or qFound
            if node.right:
                pf, qf = dfs(node.right, p, q)
                # Check if p or q is already found in the right subtree
                # Update local pFound/qFound
                pFound = pf or pFound
                qFound = qf or qFound

            # If pFound and qFound is True, this means the nodes p and q have BOTH been found either at the current node or in the left/right subtrees
            if pFound and qFound:
                # Set the current node as LCA only if it is None
                # The first common ancestor that is found is returned
                if LCA[0] is None:
                    LCA[0] = node
                    # Terminate early
                    return False, False
            # Return local information to parent nodes
            return pFound, qFound

        dfs(root, p, q)
        return LCA[0]
