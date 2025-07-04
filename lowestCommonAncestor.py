# Time Complexity:O(h)
# Space Complexity:O(h) if recursion  O(1) if iterative
# Approach: Brute force would be find 2 paths of BST .start from idx 0 and find where elements are not equal
# but this is bst we cna use BST props .we will decide to move left or right based on current root value.
#  cases wouldbe 
#      p  or inverse        or   /   \
#     /
#    ...
#   /
#  q

# if root val is lesss than both left and right  move right
# if p/q<root<p/q return root
# else move left

# At most we sould be travesing H nodes
# this canbe done with both interative and recursion


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #BRUTE FORCE WOULD BE JUST FIND PATH AND CHEKC EACH PARENT AND SE HWERE EQUALITY FALIS BUT THIS IS  BST CAN DO SIMILAR THING TO BIANRY SEARCH
        while(root):
            if p.val<root.val and q.val <root.val:
                root=root.left
            elif p.val>root.val and q.val >root.val:
                root=root.right
            else: return root
        return root



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.paths=[]

        def pathFinder(root,target,path):
            if not root   :
                return 
            # if not root.left and not root.right:
            #     if root.val==target.val:
            #         path.append(root)
            #         self.paths.append(path)
            #     return 
            

            if root.val==target.val:
                path.append(root)
                self.paths.append(path)
                return 
            # print(root.val)
            if root.val>target.val:
                 
                pathFinder(root.left,target,path+[root])
            if root.val<target.val:
                pathFinder(root.right,target,path+[root])
            if len(path):
                path.pop()
        pathFinder(root,p,[])
        pathFinder(root,q,[])
        # for i in self.paths:
        #     print(i)
        print(self.paths)
        p1,p2=self.paths[0],self.paths[1]
        ans=p1[0] #for sure root always be in path ,worst case it will be LCA
        n=min(len(p1),len(p2))
        for i in range(n):
            if p1[i]==p2[i]:
                ans=p1[i]
            else:
                break
        return ans








        
