#Time Complexity:O(log n)
#Space complexity:O(h)
#Ran successfully on Leetcode:Yes
#Algorithm:Considering the BST property where we find lesser value in root'left. chid, we go on exploring left then if we do not find the kth smallest we go and explore towards right.

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st=[]
        while True:
            while root:
                st.append(root)
                root=root.left
            root=st.pop()
            k-=1
            if not k :
                return root.val
            root=root.right
