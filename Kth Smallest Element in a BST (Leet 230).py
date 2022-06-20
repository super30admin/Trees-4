'''
Iterative Approach
Time: O(n)
Space: O(n)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st = list()
        while root != None or len(st) != 0:
            while root != None:
                st.append(root)
                root = root.left
            
            root = st.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right


'''
Recursive Approach
Time: O(n)
Space: O(H), recursive stack
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.helper(root)
        return self.result
    
    def helper(self, root):
        if root is None:
            return
        
        self.helper(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root.val
            return
        self.helper(root.right)


# using return int

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        return self.helper(root)
        
    
    def helper(self, root):
        if root is None:
            return 0
        
        left = self.helper(root.left)
        self.count -= 1
        if self.count == 0:
            return root.val
        right = self.helper(root.right)
        return left + right

'''
Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

Instead of doing the same search again and again, we can follow two approaches:
1. adding rank attribute to the node, but when we insert or delete, we have to traverse and modify the ranks again (not efficient).

Finding we'll get logarithmic in worst case but not insertion and deletion.

2. adding left count attribute to the each node, for searching the kth smallest or largest it's easy to search for multiple operations, when we add an element, we can increase the count while traversing
till the null and add it and similar approach to be followed for delete.

Instead of iterating all the elements, i can traverse through the height (logarithmic) of tree for add and delete and search as well (smallest and largest).

for adding the count attribute, i'll create the new tree with the original tree with new attribute (left count), initally 0, increase the count by 1 while inserting the node in the new tree. This is done only once then insersion, finding and deletion (logarithmic).

'''