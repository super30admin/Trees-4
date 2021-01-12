# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        #recursive inorder property of bst> either form resultant array and store or just return element on the fly when count reaches k
        #O(max(n,h))>h when found in left height .....n when found on right half (complete full left and come to right)
        #O(h)>stack space
    #     if not root:
    #         return -1
    #     self.k=k
    #     self.res=-1
    #     self.inorder(root)
    #     return self.res
    # def inorder(self,root):
    #     if not root:
    #         return
    #     self.inorder(root.left)
    #     self.k-=1
    #     if self.k==0:
    #         self.res=root.val
    #         return 
    #     self.inorder(root.right)
    
    
    #iterative
        if not root:
            return -1
        st=[]
        while root or st:
            while root:
                st.append(root)
                root=root.left
            root=st.pop()
            k-=1
            if k==0:
                return root.val
            root=root.right
        return -1
    
    #followup
    '''
maintain a hashMap to record val<-->idx(ith smallest)
Also maintain an inorderlist of val based on ascending order.

insert a node:
1.1. find insert point, we got either predecessor node val or successor node val;
1.2. search hashMap with the predecessor node val or successor val; then we get a preIdx or nextIdx;
1.3. Insert the new node to list;
delete a node:
2.1. get the node idx from HashMap;
2.2. list.remove(idx);
Then we can always get kth smallest value by list.get(k);
'''