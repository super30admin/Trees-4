'''
235 Lowest Common Ancestor of a Binary Search Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2


Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

Solution 1:
1. Recursive 1 (DFS):
Move root to left if both p and q are smaller than root.
Move root to right if both p and q are greater than root.
If none of the above conditions hold, then either:
a) root is the LCA and root != p and root ! = q. That is, p lies to the left and q lies to the right of root.
b) root is the LCA and root is either of p or q.

Time: O(H), Space: O(H),
where H = log N (for balanced tree), H = N (skewed tree)

2. Recursive 2 (DFS):
Same as Recursive 1 but the code is more compact

https://www.youtube.com/watch?v=kxYiz2Qxujk
Time: O(H), Space: O(H)

3. Iterative 1:
Iterative version

Time: O(H), Space: O(1)
'''
from binary_tree import *

def lowestCommonAncestorBST_recur_1(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    ''' Time: O(H), Space: O(H) '''
    if not root:
        return None

    if root.val > p.val and root.val < q.val:
        lca = root
    elif root.val <= p.val and root.val <= q.val:
        if root.val == p.val or root.val == q.val:
            lca = root
        else:
            lca = lowestCommonAncestorBST_recur_1(root.right, p, q)
    elif root.val >= p.val and root.val >= q.val:
        if root.val == p.val or root.val == q.val:
            lca = root
        else:
            lca = lowestCommonAncestorBST_recur_1(root.left, p, q)
    return lca

def lowestCommonAncestorBST_recur_2(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    ''' Time: O(H), Space: O(H)
        Balanced Tree: H = log N
        Skewed Tree: H = N
    '''
    if not root:
        return None
    if p.val < root.val and q.val < root.val:
        return lowestCommonAncestorBST_recur_2(root.left, p, q)
    elif p.val > root.val and q.val > root.val:
        return lowestCommonAncestorBST_recur_2(root.right, p, q)
    else:
        # The else case holds when:
        # min(p.val, q.val) <= root.val <= max(p.val, q.val)
        # W/o loss of generality, assume min(p,q) = p, max(p,q) = q
        # Then, the else condition an be expanded to the following.
        # a) p.val < root.val < q.val
        # b) p.val = root.val < q.val
        # c) p.val < root.val = q.val
        # All (a)-(c) are explicitly stated in the previous recur_1 solution
        # whereas they are squeezed into a single else statement in this solution
        return root


def lowestCommonAncestorBST_iter_1(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    ''' Time: O(H), Space: O(1)
        Balanced Tree: H = log N
        Skewed Tree: H = N
    '''
    if not root:
        return None
    while True:
        if p.val < root.val and q.val < root.val:
            root = root.left
        elif p.val > root.val and q.val > root.val:
            root = root.right
        else:
            return root

def run_lowestCommonAncestorBST():
    tests = [([6,2,8,0,4,7,9,None,None,3,5],2,8,6),
             ([6,2,8,0,4,7,9,None,None,3,5],3,5,4),
             ([6,2,8,0,4,7,9,None,None,3,5],7,9,8),
             ([6,2,8,0,4,7,9,None,None,3,5],2,4,2),
             ([6,2,8,0,4,7,9,None,None,3,5],4,2,2),
             ([6,2,8,0,4,7,9,None,None,3,5],7,8,8),
             ([6,2,8,0,4,7,9,None,None,3,5],8,7,8)
    ]
    for test in tests:
        root, p, q, ans = test[0], test[1], test[2], test[3]
        tree=build_tree_level_order(root)
        tree.display()
        node_p = search_bst(tree, p)
        node_q = search_bst(tree, q)
        print(f"\nroot = {root}")
        print(f"p = {p}")
        print(f"q = {q}")
        for method in ['recur_1', 'recur_2', 'iter_1']:
            if method == "recur_1":
                lca = lowestCommonAncestorBST_recur_1(tree, node_p, node_q)
            elif method == "recur_2":
                lca = lowestCommonAncestorBST_recur_2(tree, node_p, node_q)
            elif method == "iter_1":
                lca = lowestCommonAncestorBST_iter_1(tree, node_p, node_q)
            success = (ans == lca.val)
            print(f"Method {method}:  LCA = {lca.val}")
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_lowestCommonAncestorBST()