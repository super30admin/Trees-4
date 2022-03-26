/*
Time Complexity: O(N), N is the number of nodes in the tree
Space Complexity: O(H), H is the height of the recursion tree
Run on leetcode: yes
Any difficulties: no

Approach:
1. I will be using property of the binary search tree, all the node right side of the root would be greater than root,
and vice versa
2. I will compare my given tree node values from root and do recursion to find out the common ancestor for the given p and q
tree node
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode lowestCommonAncestorOfABinarySearchTree(TreeNode root, TreeNode p, TreeNode q){
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal>parentVal && qVal>parentVal){
            return lowestCommonAncestorOfABinarySearchTree(root.right, p, q);
        }else if(pVal<parentVal && qVal<parentVal){
           return lowestCommonAncestorOfABinarySearchTree(root.left, p,q);
        }else{
            return root;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("Lowest common ancestor in binary search tree: "+lowestCommonAncestorOfABinarySearchTree(root,
                new TreeNode(2),
                new TreeNode(8)).val);
    }
}
