#Using iterative dfs approach to solve this problem
#Time complexity: O(h)
#Space complexity: O(n)
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        s = list()
        count = 0 
        node = root
        
        while True:
            if node is not None:
                s.append(node)
                node = node.left
            elif len(s) > 0:
                node = s.pop()
                count = count + 1
                if count == k:
                    return node.val
                node = node.right
            else: 
                break
                
        return -1