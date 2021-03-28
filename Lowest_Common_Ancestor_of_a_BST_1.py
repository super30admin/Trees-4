# Created by Aashish Adhikari at 2:34 PM 3/26/2021

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

'''
Time Complexity:
O(n.2n) ~ O(n.n) since at each node, we are searching for two nodes

Space Complexity:
O(n.2n)
'''

class Solution(object):



    def find_a_node(self, root, node_to_find):

        recursive_stack = []
        node = root

        while node is not None or len(recursive_stack) != 0:


            # traverse the left side
            while node is not None:
                if node == node_to_find:
                    return True
                recursive_stack.append(node) # put the parent in the recursive stack
                node = node.left             # now go to the left child


            # the parent
            node = recursive_stack.pop()
            if node == node_to_find:
                return True




            # traverse right
            node = node.right

        # if not found, return False
        return False


    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        latest_ancestor = root

        # Traverse the tree, at each node, check if both the nodes can be reached from the current node, if True, continue until no such node is found and return the last node that was able to.
        stack = []

        # if root.left is not None:
        #     stack.append(root.left)
        # if root.right is not None:
        #     stack.append(root.right)

        stack.append(root)
        FOUND = True # as both the nodes can be found from the root at first
        while len(stack) != 0:

            current_root = stack.pop()

            P_FOUND = True if current_root == p else self.find_a_node(current_root, p) # since a root is allowed to be its own ancestor
            Q_FOUND = True if current_root == q else self.find_a_node(current_root, q)


            if P_FOUND and Q_FOUND:

                # means this node can can find both

                if current_root.left is not None:
                    stack.append(current_root.left)
                if current_root.right is not None:
                    stack.append(current_root.right)

                # update the last LCA
                latest_ancestor = current_root
            else:
                if P_FOUND or Q_FOUND:
                    return latest_ancestor
                else:
                    pass








