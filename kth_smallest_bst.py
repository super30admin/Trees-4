#ITERATIVE SOLUTION
#Time complexity: O(n)
#Space Complexity: O(H) (call stack, h=log(n) if balanced)
'''
do an inorder traversal and return the kth element that is poped.
An inorder traversal of BST is a sorted array.

'''
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st=[]
        while st or root:
            while root:
                st.append(root)
                root=root.left
            root=st.pop()
            k-=1
            if k==0: return root.val
            root=root.right
            
            
#RECURSIVE SOLUTION
#Time complexity: O(n)
#Space Complexity: O(H) (call stack, h=log(n) if balanced)
'''
do an inorder traversal and return the kth element that is poped.
An inorder traversal of BST is a sorted array.

'''
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        found=None
        def helper(root):
            nonlocal found,k
            if not root k<=0:
                return 
            helper(root.left)
            k-=1
            if k==0: found=root
            helper(root.right)
        helper(root)
        return found.val
