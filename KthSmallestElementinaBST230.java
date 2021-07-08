import java.util.Stack;
//time complexity : O(k);
//space complexity : O(k);
//leet code : yes
//steps : inorder traversal ..left root and right;
class KthSmallestElementinaBST230 {

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
         class Wrapper{
             int result;
             int K;

             Wrapper(int k){
                 this.K = k;
             }
         }
        
    
        public int kthSmallest(TreeNode root,int k) {
            Wrapper wrapper = new Wrapper(k);
            inOrder(root,wrapper);
            return wrapper.result;
        }
        
        public void inOrder(TreeNode root, Wrapper wrapper){
            if(root==null) return;
            
            inOrder(root.left,wrapper);
            wrapper.K--;
            if(wrapper.K==0){
                wrapper.result = root.val;
                return;
            }
            inOrder(root.right,wrapper);
            
        }
    }
}
        /** 
        if(root==null) return 0;
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode cursor = root;
        
        while(cursor!=null){
            stack.push(cursor);
            cursor = cursor.left;
        }
        
        while(!stack.isEmpty()){
            cursor = stack.pop();
            k--;
            
            
            if(k==0){
                return cursor.val;
            }
            
            if(cursor.right!=null){
                cursor = cursor.right;
                while(cursor!=null){
                    stack.push(cursor);
                    cursor = cursor.left;
                }
            }
            
            
            
        }
        return 0;
        
        
    }
*/
/**
 *  using system stack
 * int K, result;
    
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        inOrder(root);
        return result;
    }
    
    public void inOrder(TreeNode root){
        if(root==null) return;
        
        inOrder(root.left);
        K--;
        if(K==0){
            result = root.val;
            return;
        }
        inOrder(root.right);
        
    }

 * 
 * 
 */
