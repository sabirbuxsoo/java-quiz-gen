/**
 * This class handles the traversal of Binary Search Tress, AVL Trees and Red Black Trees
 * Input is a tree node
 * Ouput can be inorder, preorder or postorder traversals
 * Author: Sabir Buxsoo
 * Reference for Traversal Algorithms: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
public class Traversal {
    private static String preOrderOutput = ""; //Holds output of pre-order traversal
    private static String postOrderOutput = ""; //Holds output of post order traversal
    private static String inOrderOutput = ""; //Holds output of in order traversal

    /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
      void postOrder(Node node) 
      { 
          if (node == null) 
              return; 
    
          // Recur left subtree
          postOrder(node.left); 
    
          // Recur right subtree 
          postOrder(node.right); 
    
          // Concatenate node element to string 
          postOrderOutput += node.data + " ";
      } 
    
      /* Given a binary tree, print its nodes in inorder*/
      void inOrder(Node node) 
      { 
          if (node == null) 
              return; 
    
          // Recur left child
          inOrder(node.left); 
    
          // Concatenate node element to string
          inOrderOutput += node.data + " ";
    
          //Recur right child
          inOrder(node.right); 
      } 
    
      /* Given a binary tree, print its nodes in preorder*/
      void preOrder(Node node) 
      { 
          if (node == null) 
              return; 
    
          // Concatenate node element to string
          preOrderOutput += node.data + " ";
    
          // Recur left subtree
          preOrder(node.left); 
    
          // Recur right subtree
          preOrder(node.right); 
      } 

      //Get in-order traversal
      public String getInOrder(){
          return inOrderOutput;
      }

      //Get post-order traversal
      public String getPostOrder(){
          return postOrderOutput;
      }
      
      //Get pre-order traversal
      public String getPreOrder(){
          return preOrderOutput;
      }

      //Reset inOrderOutput
      void setInOrder(){
          inOrderOutput = "";
      }
      
      // Reset postOrderOutput
      void setPostOrder(){
          postOrderOutput = "";
      }

      //Reset preOrderOutput
      void setPreOrder(){
          preOrderOutput = ""; 
      }

}
