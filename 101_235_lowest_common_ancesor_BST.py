# Done on July 23, 2020

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # Method 1 : Recursion
        # Time complexity : O(height),
        # traverse all nodes, for complete binary tree O(logn), skewed tree O(n)
        # Space complexity : O(h) (height) , stack space over the hood
        # no external DS needed , stack space under the hood
        '''
        - compare current node with p and q
        - moment u see split: return root
        - else keep compring with p and q and decide directions
        - p < root; q< root: got to left

        Problem:
        - check with p.val and q.val NOT p q
        - remember if both p and q of them are tree, we will find the tree
        - we never hit the null
        '''

        # recursive starts here
        '''
        if not root: return

        # put return root condition at the end, so that edge case [2,1] p = 2 q= 1 can be handled
        # if I write like th code below, I am asusming p is always lesser than q

        if p.val <= root.val and q.val >= root.val: # one less one greater
            return root# why not return root.val

        '''

        # one way
        '''
        if p.val<root.val and q.val<root.val: # both less go to left
            return self.lowestCommonAncestor(root.left,p,q)
        elif p.val>root.val and q.val>root.val:  # both greater go to right
            return self.lowestCommonAncestor(root.right,p,q)
        else: return root

        '''

        # second  way
        '''
        if (p.val <= root.val and q.val >= root.val) or (p.val >= root.val and q.val <= root.val): # one less one greater
            return root # why not return root.val? because return type is tree node
        elif p.val<root.val and q.val<root.val: # both less go to left
            return self.lowestCommonAncestor(root.left,p,q)
        elif p.val>root.val and q.val>root.val:  # both greater go to right
            return self.lowestCommonAncestor(root.right,p,q)

        '''

        # Method 2 : Iterative
        # Time complexity : O(height),
        # traverse all nodes, for complete binary tree O(logn), skewed tree O(n)
        # Space complexity : O(1), No stack needed
        # no external DS needed , stack space under the hood

        # check here even if we remove None condition, we just say true it will work
        while root != None:  # while(true) also works
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root





