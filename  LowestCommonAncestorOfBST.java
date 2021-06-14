
//Time: O(n)
//space: O(1)
//Did it run on leetcode: yes
class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left, p, q);
        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
        // return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //until true
        while(true){
            //if p and q less than root, move to left
            if(p.val<root.val && q.val<root.val) root = root.left;
                //if p and q greater than root, move to right
            else if(p.val>root.val && q.val>root.val) root =  root.right;
                //get the result
            else return root;
        }
    }

}