#Using recursive dfs to solve this problem
#Time Complexity: O(h)
#Space Complexity: O(1)
class TreeNode:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class Tree:
    def __init__(self):
        self.result = list()
        self.result1 = list()

    def dfs(self,node,p,q):
        if node is None:
            return
        if node == p or node == q:
            return True
        left = self.dfs(node.left,p,q)
        right = self.dfs(node.right,p,q)
        if left == True and right == True:
            print(node.data)
            return node

n1 = TreeNode(3)
n2 = TreeNode(5)
n3 = TreeNode(1)
n4 = TreeNode(6)
n5 = TreeNode(2)
n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5
t = Tree()
n = t.dfs(n1,n4,n5)
