#Time Complexity O(N)
#Space complexity O(N)

class TreeNode:

    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None


class kthElement:

    def bst(self, root, k):

        res = []
        def dfs(root):
            nonlocal res
            if root:
                dfs(root.left)
                res.append(root.val)
                dfs(root.right)
            
            else:
                return

        dfs(root)

        return res[k-1]




element = TreeNode(3)
binaryTree = element
binaryTree.left = TreeNode(1)
binaryTree.left.right = TreeNode(2)
binaryTree.right = TreeNode(4)


result = kthElement()
res = result.bst(element, 1)
print(res)