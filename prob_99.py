#leetcode 230
# time : O(n)
# space :  O(n) #lst of order n
# algo : inorder traversal of tree and then find the kth argest element as in inoerder treversal -- Brute force
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        lst = []
        self.inorder(root, lst)
        return lst[k - 1]

    def inorder(self, root, lst):
        # Base Case
        if root is None: return

        # Logic
        self.inorder(root.left, lst)
        lst.append(root.val)
        self.inorder(root.right, lst)
#time - O(h+k)
# space :  O(h+k)
#algo : Keep adding all the left elements to stcak and then start popping elements and keep decrementing count k, till we get 0 and then give out the element
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        found = False
        while not (found):
            while root != None:
                stack.append(root)
                root = root.left

            root = stack.pop()
            k -= 1
            if k == 0:
                found = True
                break;
            root = root.right
        return root.val
