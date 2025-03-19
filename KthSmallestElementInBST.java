/*
  TC-O(N) , SC-O(1)
*/
public class KthSmallestElementInBST {
    int result;
    int element;
    public int kthSmallest(TreeNode root, int k) {
        this.result=0;
        this.element=k;
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        element--;
        if(element==0) {
            result=root.val;
        }
         inorder(root.right);
    }
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
        this.right = right;
     }
 }

}
/*
//inorder traversal, TC-O(N) SC-O(N)
   public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> lst=new ArrayList<>();
        inorder(root,lst);
        return lst.get(k-1);
    }
    public void inorder(TreeNode root, ArrayList<Integer> lst){
        if(root==null) return;
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }

 */