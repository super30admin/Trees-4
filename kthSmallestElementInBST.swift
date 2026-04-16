//
//  kthSmallestElement.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/14/26.
//

/*
 Approach 1 - Take a pointer. Do inorder traversal and for each enountered element, increment the ointer. If the pointer is equal to k then we got the answer. Inorder traversal of BST is a sorted array. Time complexity - O(n)
 However,if we are given k again and again then how will we find out the kth smallest element.
 //if the tree is not changing - then store inorder traversal in an array and direct give answers.
 //if the tree is changing
 
 iterator will take O(n) time complexity.
 
 solution - we will maintain ranking. We wouldn't put ranking like 12345.... Because tomorrow if any element is deleted then again we will find ranking for the whole tree. and will be doing O(n) traversal
 We can have a new tree. There we can maintain a value where we have the count of left elements for each node.
 For eg if we want to find 9th smallest then check the left elements of root.
 If count of left elements of root including root is 8, then go towards right.
 
 If we want to delete or insert a node in BST, then it will be done in log n time. When traversing to delete 70 then keep on delting the count by 1 for node from where we go towards left side.Then update the left count. Left count will be reduced by 1.
 During insertion also, update the left count if we are inserting in the left subtree of a node.
 
 Make a new Treenode -> value and leftValue. On constructor, One by one insert all the nodes of Tree1 in the new tree and keep track of left count as well. For once, in constructor, it will take O(n logn) time. Insertiogn of each element is log n.
 After that kth smallest, insert and delete will always take log n time.
 
 left ranking is a better approach rather than taking right ranking.
 
 If we want to find out kth largest then make right recursive call first.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */

class TNode {
    var val: Int
    var leftCount: Int = 0
    var left: TNode?
    var right: TNode?

    init(val: Int) {
        self.val = val
    }
}

class KthSmallestElementInBST {

    var tRoot: TNode?

    init(_ originalRoot: TreeNode?) {
        self.tRoot = build(originalRoot).node
    }

    //tree construction is O(n)
    func build(_ node: TreeNode?) -> (node: TNode?, size: Int) {
        guard let node = node else {
            return (nil, 0)
        }

        let leftSubtree = build(node.left)
        let rightSubtree = build(node.right)

        let newTNode = TNode(val: node.val)
        newTNode.left = leftSubtree.node
        newTNode.right = rightSubtree.node
        //Set the left count of current node to the size of the left subtree.
        newTNode.leftCount = leftSubtree.size

        let totalSize = 1 + leftSubtree.size + rightSubtree.size
        return (newTNode, totalSize)
    }

    //O(h) time complexity
    //space complexity - O(n) because a complete new tree is constructed to keep the count
    func kthSmallest(_ root: TreeNode?, _ k: Int) -> Int {
        helper(tRoot, k: k)
    }

    func helper(_ root: TNode?, k: Int) -> Int {
        guard let root = root else {
            return -1
        }

        if (k <= root.leftCount) {
            return helper(root.left, k: k)
        } else if (k == root.leftCount + 1) {
            return root.val
        } else {
            return helper(root.right, k: k - root.leftCount - 1)
        }
    }
}

