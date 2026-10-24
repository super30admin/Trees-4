'''
230 Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

Solution:
1. Inorder traversal using recursion:
Do inorder traversal of BST, store each element in an array as you traverse the tree. After traversal is complete, go to the array and pick the k-1th element.
Note: Inorder traversal of BST generates a sequence in ascending order.
Time: O(N), Space: O(H)

2. Inorder traversal + Counting elements using recursion:
Similar to the recursive approach in #1 but we also increment a counter as we visit each node in the BST.
Time: O(K), Space: O(H)
https://youtu.be/sWel_uIgUlY?t=3686

3. Inorder traversal + Counting elements using iteration:
Similar to the approach in #2 but we visit each node in the BST using iteration.
Time: O(K), Space: O(1)
'''
from typing import Optional
from binary_tree import *

def kthSmallestBST_recur(root: Optional[TreeNode], k: int) -> int:
    ''' Time: O(K), Space: O(H) '''
    def inorder(root):
        nonlocal count, answer
        if not root:
            return

        # this check prevents further traversal
        # of BST once the desired answer
        # has been found
        if answer != -9999999:
            return

        inorder(root.left)
        count += 1
        if count == k:
            answer = root.val
            return
        inorder(root.right)


    if not root:
        return -1
    count = 0
    answer = -9999999
    inorder(root)
    if answer == -9999999:
        answer = -1
    return answer


# Inorder Traversal + Counting elements using iteration
def kthSmallestBST_iter(root: Optional[TreeNode], k: int) -> int:
    ''' Time: O(K), Space: O(1) '''
    if not root:
        return -1

    stack = []
    curr = root
    answer = -9999999
    count = k

    while (stack or curr) and answer == -9999999:
        while curr:
            stack.append(curr)
            # print(f"push left: {curr.val}")
            curr = curr.left

        # curr must be None at this point
        # pop the prev left child
        curr = stack.pop()
        count -= 1
        if curr and count == 0:
            answer = curr.val
            # print(f"pop left: {curr.val}")

        # make the right child as the curr node
        curr = curr.right

    if answer == -9999999:
        answer = -1
    return answer

def run_tests():
    tests = [([6,2,8,0,4,7,9,None,None,3,5],1,0),
             ([6,2,8,0,4,7,9,None,None,3,5],2,2),
             ([6,2,8,0,4,7,9,None,None,3,5],8,8),
             ([6,2,8,0,4,7,9,None,None,3,5],9,9),
             ([6,2,8,0,4,7,9,None,None,3,5],10,-1),
    ]
    for test in tests:
        root, k, ans = test[0], test[1], test[2]
        tree=build_tree_level_order(root)
        tree.display()
        print(f"\nroot = {root}")
        print(f"k = {k}")
        for method in ["recur", "iter"]:
            if method == "recur":
                result = kthSmallestBST_recur(tree, k)
            elif method == "iter":
                result = kthSmallestBST_iter(tree, k)
            print(f"Method {method}:  Kth smallest element = {result}")
            passed = (ans == result)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()