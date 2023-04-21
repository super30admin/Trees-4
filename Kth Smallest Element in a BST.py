# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(h)
    global count, result
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        global result, count
        count = 0
        result = 0
        def inorder(root):
            global count, result
            if not root:
                return
            # print(count)
            inorder(root.left)

            count += 1
            if count == k:
                result = root.val
            #     print("Result", result)
            # print("Count",count,k)
            # print(root.val)

            inorder(root.right)
        print(count)
        inorder(root)
        return result

