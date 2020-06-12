//Time Complexity : O(log(n))  We'll be removing n/2 elements on each level;
//Space Complexity : O(h) Height of the tree
//Runs successfully on leetcode
//No problem

//Here we will be checking if the elements we want to find are both on left or both or right
// if thats the case we will move our root to that side
// If that's not the case, we will be returning the root node



public class Trees_4_Problem_2_LCAbst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else
        {
            return root;
        }

    }
}
