/*
Recursion:
TC: In an unbalanced bst, if the p, q are at the bottom of the tree. We need to traverse whole tree to find lca. 
For ex:             5
                  4
                3
              2
            1

To find lca of 1 and 2, we traverse the whole tree. So, TC : O(N) and SC: O(N)
But for a balanced bst, the search space is reduced by half everytime. TC: O(logN) and SC: O(logN)

1. Compare the p and q with root node. If both lie to the right of root. Move right.
2. If both p and q lie to the left, move left.
3. Return if both are on either side of root. 

Iterative approach:
TC: Skewed: O(N) or O(H), balanced: O(logN)
SC: O(1) 

Iterative is similar to recursion, but we are not storing the root in stack. 
Keep moving the root to right or left and when we find the split point, return the root. 

*/

public class LCAbst{

    public TreeNode lcaRecursion(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        //logic
        if(p.val < root.val && q.val < root.val)
            return lcaRecursion(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)
            return lcaRecursion(root.right, p, q);
        else return root;

    }

    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        //logic
        while(root != null){
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else return root;
        }

        return null;

    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(4);
        LCAbst bst = new LCAbst();

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        
        bst.lcaRecursion(root, p, q);
        System.out.println(bst.lcaIterative(root, p, q));

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}