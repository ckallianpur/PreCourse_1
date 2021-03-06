import java.util.LinkedList; 
import java.util.Queue; 
class GFG { 
       
    /* A binary tree node has key, pointer to  
    left child and a pointer to right child */
    static class Node { 
        int key; 
        Node left, right; 
          
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    } 
    static Node root; 
    static Node temp = root; 
      
    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) 
    { 
        if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.key+" "); 
        inorder(temp.right); 
    } 
       
    /*function to insert element in binary tree */
    static void insert(Node temp, int key) 
    { 
    	Node newNode = new Node(key);
    	Queue<Node> que = new LinkedList<Node>();
    	if (temp == null)
    	{
    		temp = newNode;
    		return;
    	}
    	else
    	{
        	que.add(temp);	
    	}
    	while (!que.isEmpty())
		{
			Node popped = que.remove();
			if (popped.left == null) {
				popped.left = newNode;
				return;
			} else if (popped.right == null) {
				popped.right = newNode;
				return;
			} else {
				que.add(popped.left);
				que.add(popped.right);
			}
		}
    } 
       
    // Driver code 
    public static void main(String args[]) 
    {
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.left.right = new Node(15);
        root.right = new Node(9); 
        root.right.right = new Node(8); 
       
        System.out.print( "Inorder traversal before insertion:"); 
        inorder(root); 
       
        int key = 12; 
        insert(root, key); 
       
        System.out.print("\nInorder traversal after insertion:"); 
        inorder(root); 
    } 
}