import copy



# Using Bottom-up recursion

class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if not root or root == p or root == q:

            return root



        left = self.lowestCommonAncestor(root.left, p, q)

        right = self.lowestCommonAncestor(root.right, p, q)



        if not left and not right:

            return

        elif left and not right:

            return left

        elif not left and right:

            return right

        else:

            return root



# Using Backtracking

class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        

        self.pAncestors = []

        self.qAncestors = []



        self.getNodeAncestors(root, p, q, [])



        minL = min(len(self.pAncestors), len(self.qAncestors))

        if minL == len(self.pAncestors):

            minA = self.pAncestors

        else:

            minA = self.qAncestors



        for i in range(0, minL):

            if self.pAncestors[i].val != self.qAncestors[i].val:

                return minA[i-1]



        return minA[-1]



    def getNodeAncestors(self, node, p, q, path):

        if not node:

            return



        path += [node]

        if node == p:

            self.pAncestors = copy.deepcopy(path)

        if node == q:

            self.qAncestors = copy.deepcopy(path)



        self.getNodeAncestors(node.left, p, q, path)

        self.getNodeAncestors(node.right, p, q, path)

        

        path.pop()

