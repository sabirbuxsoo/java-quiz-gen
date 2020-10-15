//Node Class for the AVL Tree
//Author: Sabir Buxsoo
public class AVLNode {
    int key, height; 
	Node left, right; 

	AVLNode(int d) 
	{ 
		key = d; 
		height = 1; //Height set to 1. This is very important in the AVL tree Data Structure
	} 
}
