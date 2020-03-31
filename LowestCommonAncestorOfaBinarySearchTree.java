// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root != null){

        if(p.val < root.val && q.val < root.val){
            root = root.left;
        }

        else if(p.val > root.val && q.val > root.val){
            root = root.right;

        }
        else{
            return root;
        }

    }

        return null;
    }
}