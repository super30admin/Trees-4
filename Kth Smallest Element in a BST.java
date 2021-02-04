// One approach is to do inorder traversal and take elements in array and then just return via the index position
/*
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return -1
        
        stack = []
        while root is not None or len(stack) > 0:
            while root is not None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            k -=1
            if k == 0:
                return root.val
            root = root.right
        return -1


# recursive
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return -1
        
        self.result = -1
        self.cnt = k
        self.inorder(root)
        
        return self.result
    
    def inorder(self, root):
        if root is None:
            return
        
        self.inorder(root.left)
        
        self.cnt -= 1
        if self.cnt == 0:
            self.result = root.val
            return
        
        self.inorder(root.right)
*/

/*
class Solution {
    int cnt, result;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        
        cnt = k;
        inorder(root);

        return result;    
    }
    private void inorder(TreeNode root){
        if (root == null)
            return;
        
        inorder(root.left);
        cnt --;
        if (cnt == 0){
            result = root.val;
            return;
        }
        inorder(root.right);    
        
    }
}

*/

// Time - O(h + k) since we are going down by h and then coming up by k. h == n in case of left or right skewed tree
// Space - O(h)
// Logic - Going down in the left branch and then while coming up decreasing k until it becomes zero
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        
        Stack<TreeNode> s = new Stack<>();
        
        while (root != null || !s.isEmpty()){
            while (root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0)
                return root.val;
            root = root.right;
        }
            
        return -1;    
    }
}

/*
Follow up - 
Can maintain something like this
ex:
class Node {
Node leftChild;
Node rightChild;
Node prev;
Node next;
}

The TreeNodes will have a pointer to their respective linked list node such that on a delete we can just set the TreeNode's 
linked list node's prev's next to the linked list node's next and then remove both the TreeNode and the linked list node. 
On an insert we would insert the new LinkedList node after the new TreeNode's parent's linkedlistnode.

We would maintain the head of the linked list node separately and on a call to kth smallest just iterate k times through the list.
Insertion - we can compare it with current kth smallest and if incoming node is lesser then k will shift 1 to left or it will remain same
Deleteion - we can compare it with current kth smallest and if it is smaller then k will shift 1 to right or else it will remain same
*/