#Time Complexity is O(n)   -- n being number of nodes in Tree
#Space Complexity is O(h) -- h being height of Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
#recursive
def lowestCommonAncestor(root, p, q):
    if root is None:
        return
    if root.value == p.value or root.value == q.value :
        return root
    m = lowestCommonAncestor(root.left, p, q)
    n = lowestCommonAncestor(root.right, p, q)
    if m is None:
        return n
    if n is None:
        return m
    return root