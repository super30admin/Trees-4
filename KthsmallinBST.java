//T.C- O(H+k)
//S.C- O(h)
import java.util.ArrayList;
import java.util.Stack;


//   Definition for a binary tree node.
  public class KthsmallinBST {
      int val;
      KthsmallinBST left;
      KthsmallinBST right;
      KthsmallinBST() {}
      KthsmallinBST(int val) { this.val = val; }
      KthsmallinBST(int val, KthsmallinBST left, KthsmallinBST right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {
    private ArrayList<Integer> inorder(KthsmallinBST root, int k, ArrayList<Integer> arr){
            Stack<KthsmallinBST> Stack= new Stack<>();
            while(root!=null || !Stack.isEmpty()){
                while(root!=null){
                    Stack.push(root);
                    root= root.left;
                }
                root= Stack.pop();
                arr.add(root.val);
                root=root.right;
            }
        return arr;
        }
    public int kthSmallest(KthsmallinBST root, int k) {
        ArrayList<Integer> arr= new ArrayList<>();
        inorder(root,k,arr);
        return arr.get(k-1);
    }
    
}
