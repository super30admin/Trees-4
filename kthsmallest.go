// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set count to k and init result
if root != nil call recursive function with root and count
return result

in recursive function
if root is nil return
call recursive on root.Left
then count--
if count is 0 return root.Val as result
call recursive on root.Right
*/
package main

import "fmt"

func kthSmallest(root *TreeNode, k int) int {
	/*st := []*TreeNode{}
	  for root != nil || len(st) > 0 {
	      for root != nil {
	          st = append(st, root)
	          root = root.Left
	      }
	      root = st[len(st) - 1]
	      st = st[:len(st) - 1]
	      k--
	      if k == 0 {
	          break;
	      }
	      root = root.Right
	  }
	  return root.Val // O(h+k)*/


	count = k
	if root == nil {
		return -1
	}
	inorder(root, k)
	return result
}

var count int
var result int
func inorder(root *TreeNode, k int) {
	if root == nil {
		return
	}
	inorder(root.Left, count)
	count--
	if count == 0 {
		result = root.Val
		return
	}
	inorder(root.Right, count)
}

func MainKthSmallest() {
	q := &TreeNode{Val: 4}
	p := &TreeNode{Val: 3, Left: &TreeNode{Val: 2, Left: &TreeNode{Val: 1}}, Right: q}

	root := &TreeNode{Val: 5, Left: p, Right: &TreeNode{Val: 6}}
	fmt.Println(kthSmallest(root, 3)) //expected 3
}
