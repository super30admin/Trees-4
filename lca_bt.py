'''
236 Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 105].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the tree.


Solution:
1. Top Down Recursion (straight forward)
Track the traversal path as we visit each node during tree traversal. When we hit p or q, we store the paths (one each for p and q). Then, when we are done finding p and q, we exit the traversal and compare the two paths to find the first index where the mismatch (of ancestor) occurs. The element prior to the first mismatch index is the LCA. It is called top-down recursion since we start saving the ancestors from the root (top).
Time: O(N), Space: O(4H) = O(H) (recursion stack + path for backtracking + 2 lists for storing ancestors)
https://youtu.be/kxYiz2Qxujk?t=1283

2. Bottom Up Recursion (tricky)
We can avoid populating the path and the 2 lists for storing the ancestors.
We check left and right subtrees recursively to find p and q.

Four possibilites:
- If both left and right subtrees return null (= p and q not found), then return None
- If both left and right calls return non-null (meaning p and q exist on left and right subtrees), the current node is the LCA.
- If left is null and right is non-null, return right is the LCA.
- If left is non-null and right is null, return left is the LCA.

This is called bottom-up recursion since we start propagating information from the leaves all the way to the top. Information flows from bottom to top.
Time: O(N), Space: O(H)
https://youtu.be/kxYiz2Qxujk?t=3404

'''
from binary_tree import *

# top-down v1 - works
# def lowestCommonAncestorBT_1(root: TreeNode, p: TreeNode, q: TreeNode) -> int:
#     ''' Top-Down Recursion: Time: O(N), Space: O(H) '''
#     def dfs(root, p, q, path):
#         nonlocal ancestors_p, ancestors_q, count
#         if not root or count == 0:
#             return

#         path.append(root.val) # action
#         #print(f"push: {path}")
#         if root.val == p.val:
#             ancestors_p = path.copy()
#             count -= 1
#         elif root.val == q.val:
#             ancestors_q = path.copy()
#             count -= 1
#         dfs(root.left, p, q, path) # recursion
#         dfs(root.right, p, q, path) # recursion
#         path.pop() # backtrack
#         #print(f"pop: {path}")

#     if not root:
#         return None
#     ancestors_p = []
#     ancestors_q = []
#     path = []
#     count = 2 # If we discover p and q, count = 0 -> we stop traversing tree
#     dfs(root, p, q, path)

#     # Creat an extra copy of the last ancestor. Why?
#     # Having the last ancestor twice in the list helps avoid dealing with lists # of unqual sizes when finding the LCA. Since we add the last node (p or q # twice, there is bound to be a mismatch (since p != q)
#     # Example: ancestor_p = [3,3], ancestor_q = [3,5,2,4,4]
#     # ancestor_p[0] = ancestor_q[0], lca = 3
#     # ancestor_p[1] != ancestor_q[1], return lca
#     ancestors_p.append(ancestors_p[-1])
#     ancestors_q.append(ancestors_q[-1])
#     prev = None
#     for x, y in zip (ancestors_p, ancestors_q):
#         # We can zip the two lists even though they may not be of equal sizes
#         if x != y:
#             break
#         else:
#             prev = x
#     lca = prev
#     return lca

# top-down v2 - easier to understand than top-down v1
def lowestCommonAncestorBT_1(root: TreeNode, p: TreeNode, q: TreeNode) -> int:
    ''' Top-Down Recursion: Time: O(N), Space: O(H) '''
    def dfs(root, p, q):
        nonlocal path, path_p, path_q
        if not root or (path_p and path_q):
            return
        if root.val == p.val:
            path_p = path.copy()
            return
        if root.val == q.val:
            path_q = path.copy()
            return

        path.append(root.val)
        dfs(root.left, p, q)
        dfs(root.right, p, q)
        path.pop()

    path = []
    path_p = []
    path_q = []
    dfs(root, p, q)

    # Post-processing steps
    # Since p and q exist in BT,
    # a) If either of p/q is a descendant of the other, then only one of the
    # paths (corresponding to the ancestor) will be non-empty.
    # b) If p/q are siblings or cousins or distant relatives, then both paths
    # will be non-empty
    if not path_p:
        return q.val
    elif not path_q:
        return p.val
    else:
        path_p.append(p.val)
        path_q.append(q.val)

    lca = None
    for a, b in zip(path_p, path_q):
        if a == b:
            lca = a
        else:
            break
    return lca


def lowestCommonAncestorBT_2(root: TreeNode, p: TreeNode, q: TreeNode) -> int:
    ''' Bottom-Up Recursion: Time: O(N), Space: O(H) '''
    def dfs(root, p, q):
        if not root:
            return None

        if root.val == p.val or root.val == q.val:
            return root

        left = dfs(root.left, p, q)
        right = dfs(root.right, p, q)

        if not left and not right:
            return None
        elif left and not right:
            return left
        elif not left and right:
            return right
        else: # left and right
            return root

    if not root:
        return None
    lca = dfs(root, p, q)
    return lca.val

def run_lowestCommonAncestorBT():
    tests = [([3,5,1,6,2,0,8,None,None,7,4],5,1,3),
             ([3,5,1,6,2,0,8,None,None,7,4],6,2,5),
             ([3,5,1,6,2,0,8,None,None,7,4],0,8,1),
             ([3,5,1,6,2,0,8,None,None,7,4],5,4,5), # interesting case
             ([3,5,1,6,2,0,8,None,None,7,4],4,5,5),
             ([3,5,1,6,2,0,8,None,None,7,4],1,8,1),
             ([3,5,1,6,2,0,8,None,None,7,4],8,1,1),
             ([3,5,1,6,2,0,8,None,None,7,4],7,1,3),
    ]
    #tests = [([3,5,1,6,2,0,8,None,None,7,4],5,4,5),]
    for test in tests:
        root, p, q, ans = test[0], test[1], test[2], test[3]
        tree=build_tree_level_order(root)
        tree.display()
        node_p = search_bt(tree, p)
        node_q = search_bt(tree, q)
        print(f"\nroot = {root}")
        print(f"p = {p}")
        print(f"q = {q}")
        for method in [1, 2]:
            if method == 1:
                lca = lowestCommonAncestorBT_1(tree, node_p, node_q)
            elif method == 2:
                lca = lowestCommonAncestorBT_2(tree, node_p, node_q)
            success = (ans == lca)
            print(f"Method {method}:  LCA = {lca}")
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_lowestCommonAncestorBT()