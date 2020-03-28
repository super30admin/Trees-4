# Problem 1 - Kth Smallest Element in a BST
## Time Complexity :
O(K)

## Space Complexity :
O(K)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def kthSmallest(self, root: TreeNode, k: int) -> int:
              if not root:
                  return 0
              stack=[]
              cursor=root
              while cursor:
                  stack.append(cursor)
                  cursor=cursor.left
              while(len(stack)!=0):
                  cursor=stack.pop()
                  k-=1
                  if k==0:
                      return cursor.val
                  if cursor.right:
                      cursor=cursor.right
                      while cursor:
                          stack.append(cursor)
                          cursor=cursor.left
              return 0


# Problem 2 -  Lowest Common Ancestor of a Binary Search Tree
## Time Complexity :
O(LogN)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
              while root:
                  if root.val > p.val and root.val > q.val:
                      root = root.left
                  elif root.val < p.val and root.val < q.val:
                      root = root.right
                  else:
                      return root
