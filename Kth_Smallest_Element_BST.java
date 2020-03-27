//Iterative Approach by maintaining our own stack
//Time: O(n)
//Space: O(h)
class Solution {
    
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return 0;
        
        Stack<TreeNode> stk = new Stack<>();
        
        //push element into stack till we hit bottom left;
        while(root!= null)
        {
            stk.push(root);
            root = root.left;
         }
        
        //start popping out the elements and traverse in inorder way
        while(!stk.isEmpty())
        {
                root = stk.pop();
                k--;
                if(k==0)
                    return root.val;
    
                if(root.right != null)
                {
                    root = root.right;
                    while(root!= null)
                    {
                        stk.push(root);
                        root = root.left;
                    }
                }
        }
        
        return 0;
 
    }
    
   
}


/* Using Recursion:

Time: O(n)
Space: O(h) -> height of the tree

class Solution {
    
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        
        count = k;
        
        inOrder(root);
        
        return result;
    }
    
    private void inOrder(TreeNode root)
    {
        if(root == null)
            return;
        
        inOrder(root.left);
        count--;
        if(count == 0)
        {
            result = root.val;
            return;
        }
        inOrder(root.right);
        
    }
}

*/



/*
Brutforce Approach: Inorder Traveral of whole tree, save it in array and then return k-1 element
Time Complexity: O(n) -> since we are visiting every single node of the tree
Space Complexity: O(n) -> inserting every node in an array

	static int kthSmallest(Node node, int k)
	{
	  List<Integer> list = new ArrayList<>();
	  InOrder(node, list);
	  
	  return list.get(k-1);

	}
	
	
	
	static void InOrder(Node node, List<Integer> list)
	{
		if(node == null)
			return;
		
		InOrder(node.left, list);
		list.add(node.data);
		InOrder(node.right, list);
		
		return;

	}

*/
