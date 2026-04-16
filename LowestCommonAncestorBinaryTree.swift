//
//  LowestCOmmonAncestorBinaryTree.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/15/26.
//

class LowestCommonAncestorBinaryTree {
    
    init() {
        
    }
    
    //MARK: for binary tree
    /*
     time complexity - O(n)
     space - recursion stack, path array - 2 O(h). Worst case - O(n)
     2 - paths array - path solution with backtracking
   
     */
    var pathP = [TreeNode]()
    var pathQ = [TreeNode]()
    func lcaUsingPathArray(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
        var path = [TreeNode]()
        helper(root, p, q, path: &path)
        var lca: TreeNode?
        let minLen = min(pathP.count, pathQ.count)
        for i in 0..<minLen {
            if (pathP[i] === pathQ[i]) {
                lca = pathP[i]
            } else {
                break
            }
        }
        return lca
    }

    //time complexity - O(n), space - O(n)
    func helper(_ root: TreeNode? , _ p: TreeNode? , _ q: TreeNode?, path: inout [TreeNode]) {
        guard let root = root else {
            return
        }
        //Stop early if both p and q found
        if (!pathP.isEmpty && !pathQ.isEmpty) {
            return
        }
        path.append(root)
        if (root === p) {
            pathP = path
        }
        if (root === q) {
            pathQ = path
        }

        helper(root.left, p, q, path: &path)

        helper(root.right, p, q, path: &path)

        path.removeLast()
    }


        
    //MARK: Bottom up approach
    /*
     time complexity - O(n)
     space complexity - O(h), recursion stack
     advantage -> If we are finding the LCA for 2 elements which are only at the left side of the root then once we find the first element then only we will return from the left side and will try to find the element at the right side. Since, at the right side nothing is found then left side retuned value will be the answer.
     */
    //bottom up approach. if an element is found at the left side and nil is found at the right side then left will be returned up. If an element is found at the right side and nil is coming up from the left side side then right will returned. If both non-nil values are coming up from left and right side means we found both p and q and current node is LCA.
    func lowestCommonAncestorBottomUp(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
        if (root == nil || root === p || root === q) {
            return root
        }

        //logic
        let left = lowestCommonAncestorBottomUp(root?.left, p, q)
        let right = lowestCommonAncestorBottomUp(root?.right, p, q)

        if (left == nil && right == nil) {
            return nil
        } else if (left == nil && right != nil) {
            return right
        } else if (left != nil && right == nil) {
            return left
        } else {
            return root
        }
    }

}
