//Binary Node tree for the BST class
//Author: Sabir Buxsoo
class Node { 
    int data, height; 
    Node left, right; 
      
    Node(){

    }

    Node(int d) { 
        data = d; 
        left = right = null; 
        height = 1;
    } 
} 
