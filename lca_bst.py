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
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the BST.

Solution 1:
1. Recursive (DFS):
Case 1: Move root to left if both p and q are smaller than root.
Case 2: Move root to right if both p and q are greater than root.
Case 3: If none of the above conditions hold, then root is the LCA.
Why root is the LCA in Case 3?
Ans: Since only three situations are left:
    a) p lies to the left and q lies to the right of root
    b) root is at q, p is left of root
    c) root is at p, q to the right of root
Time: O(H), Space: O(H)
where H = log N (for balanced tree), H = N (skewed tree)
https://www.youtube.com/watch?v=kxYiz2Qxujk

2. Iterative:
Iterative version
Time: O(H), Space: O(1)
'''
from binary_tree import *

def lowestCommonAncestorBST_recur(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    ''' Time: O(H), Space: O(H)
        Balanced Tree: H = log N
        Skewed Tree: H = N
    '''
    if not root:
        return None

    if p.val > q.val: # ensures p.val <= q.val
        lca = lowestCommonAncestorBST_recur(root, q, p)
        return lca

    if root.val > p.val and root.val > q.val:
        lca = lowestCommonAncestorBST_recur(root.left, p, q)
    elif root.val < p.val and root.val < q.val:
        lca = lowestCommonAncestorBST_recur(root.right, p, q)
    elif root.val >= p.val and root.val <= q.val:
        # The else case holds when:
        # a) p.val = root.val = q.val
        # b) p.val < root.val = q.val
        # c) p.val = root.val < q.val
        # d) p.val < root.val < q.val
        # We could have also used else: instead of elif <condn>
        return root
    return lca

def lowestCommonAncestorBST_iter(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
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

def run_tests():
    tests = [([6,2,8,0,4,7,9,None,None,3,5],2,8,6),
             ([6,2,8,0,4,7,9,None,None,3,5],3,5,4),
             ([6,2,8,0,4,7,9,None,None,3,5],5,3,4),
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
        for method in ['recur', 'iter']:
            if method == "recur":
                lca = lowestCommonAncestorBST_recur(tree, node_p, node_q)
            elif method == "iter":
                lca = lowestCommonAncestorBST_iter(tree, node_p, node_q)
            print(f"Method {method}:  LCA = {lca.val}")
            passed = (ans == lca.val)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()