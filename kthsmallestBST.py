class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def kthsmallest(root, k):
        def inorder(node):
            if not node:
                return None
            left = inorder(node.left)
            cur = [node.val]
            right = inorder(node.right)
            return left + cur + right
        sorted_list = inorder(root)
        return sorted_list[k-1]

# time complexity is O(H + K)
#space= O(H)