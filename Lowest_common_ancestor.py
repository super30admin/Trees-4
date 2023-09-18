# Time Complexity :O(Log(N))
# Space Complexity :O(1). recursive stack O(Log(N))
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:

    def helper(self, root, p, q):
        # if(root==None):
        #     return
        if(p.val>root.val and q.val<root.val):
            return root
        elif(p.val<root.val and q.val>root.val):
            return root
        elif(p.val>root.val and q.val>root.val):
            return self.helper(root.right, p, q)
        elif(p.val<root.val and q.val<root.val):
            return self.helper(root.left, p ,q)
        elif(p.val==root.val or q.val==root.val):
            return root

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if(root==None):
            return root
        return self.helper(root, p, q)
    # Iterative
        # while(root):
        #     if(p.val>root.val and q.val<root.val):
        #         return root
        #     else:
        #         if(p.val<root.val and q.val>root.val):
        #             return root
        #         else:
        #             if(p.val<root.val and q.val<root.val):
        #                 root=root.left
        #             else:
        #                 if(p.val>root.val and q.val>root.val):
        #                     root=root.right
        #                 else:

        #                     if(p.val==root.val or q.val==root.val):
        #                         return root
