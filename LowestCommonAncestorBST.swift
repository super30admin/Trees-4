//
//  LowesrCommonAncestor.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/14/26.
//

class LowesrCommonAncestorBST {
    
    init() {
        
    }
    
    //MARK: For binary search tree
    /*
     time complexity - best case - O(h), worst case - O(n)
     space - O(1)
     */
    //two problems - one using recursion, another one without recursion.
    //MARK: Recursion
    func lowestCommonAncestor(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
        guard let root = root, let p = p, let q = q else {
            return nil
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q)
        } else if ( p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q)
        } else {
            return root
        }
        return nil
    }

    //MARK: Iterative approach
    func lowestCommonAncestorUsingIterative(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
        guard let root = root, let p = p, let q = q else {
            return nil
        }
        var current: TreeNode? = root
        while let node = current {
            if (p.val < node.val && q.val < node.val) {
                current = node.left
            } else if (p.val > node.val && q.val > node.val) {
                current = node.right
            } else {
                return node
            }
        }
        return nil
    }
}
