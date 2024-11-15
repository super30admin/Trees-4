# Trees-4

# Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
# Summary: In order traversal (left, root, right) to get to the lowest value node (j =1) and keep iterating until you reach j= k and return value at that node
# Time Complexity: O(N)
# Space Complexity: O(1)
class Solution:
    j = 0
    ans = 0

    def helper(self, root: Optional[TreeNode], k: int):
        if root == None:
            return

        if self.j < k:
            self.helper(root.left, k)
        
        self.j += 1
        if self.j == k:
            self.ans = root.val

        if self.j < k:
            self.helper(root.right, k)


    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        #  in order traversal
        self.helper(root, k)
        return self.ans

# Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
# Summary: Recursion logic, if both numbers are smaller than current node then they must be to the left, if both are greater then they are to the right, 
#          if one is higher and the oher is lower than root then the elements lie on either side of current node, ie least common prefix is current node
# Time Complexity: O(log(N)) because this is a BST, we eliminate the search for number by half at each step
# Space Complexity: O(1), no extra space is being used
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if (p.val < root.val and q.val < root.val): 
            return self.lowestCommonAncestor(root.left, p, q)
        elif (p.val > root.val and q.val > root.val): 
            return self.lowestCommonAncestor(root.right, p, q)
        else: #ie p and q are on either sides of the root (base case)
            return root


# Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
# Summary: Traverse the nodes and keep a copy of path until node is found, if node not found then backtrack and remove that value from path. Compare paths in the end and find prefix
# Time Complexity: O(N)
# Space Complexity: O(H) where H is the height of tree (to copy both the paths
class Solution:
    pathP = []
    pathQ = []

    def helper(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', path):
        # base
        if root == None:
            return

        # logic
        path.append(root)

        if root == p:
            self.pathP = path.copy()
            self.pathP.append(root)

        if root == q:
            self.pathQ = path.copy()
            self.pathQ.append(root)

        # recurse
        self.helper(root.left, p, q, path.copy())
        self.helper(root.right, p, q, path.copy())

        # backtrack
        path.pop()

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path = []
        self.helper(root, p, q, path.copy())
        # print(self.pathP)
        # print(self.pathQ)
        for i in range(len(self.pathP)):
            if (self.pathP[i] != self.pathQ[i]):
                return self.pathP[i-1]

