import java.util.Arrays;

/**
 * The BST class is the main Binary Search Tree class A BST is created by taking
 * a Sorted random Array and creating a Balanced BST The class handles Insertion
 * and Deletion but does not re-balance the tree after an insertion or deletion
 * This has been done on purpose to ensure that students have a balanced BST to
 * begin with and test whether they understand the concept of deletion and
 * insertion 
 * Author: Sabir Buxsoo 
 * References:
 * https://www.geeksforgeeks.org/binary-search-tree-data-structure/
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 * https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 */
class BST {
    Traversal traversal; // Will hold an instance of the Traversal Class
    private static Node root;

    // Constructor initiates a new Traversal class
    BST() {
        traversal = new Traversal();
    }

    // This functions takes a sorted array and creates a balanced BST
    private Node generateBST(int arr[], int start, int end) {

        // Base case
        if (start > end) {
            return null;
        }

        // Get the middle element and make it as root
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        // Construct left subtree recursively and make it left child of the root
        node.left = generateBST(arr, start, mid - 1);

        // Construct right subtree recursively and make it right child of root
        node.right = generateBST(arr, mid + 1, end);

        return node;
    }

    // Method to delete an element from tree
    // Method calls deleteRec
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Deletes the element from the BST. This deletion does not rebalance the tree
    private Node deleteRec(Node root, int key) {
        // Base case (Empty Tree)
        if (root == null) {
            return root;
        }

        // Recur down the tree
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with <= 1 child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with 2 children
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Method inserts value in BST
    // Method calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /// Recursively insert in BST
    private Node insertRec(Node root, int key) {

        // If tree is empty, a new node is returned
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // If tree not empty, recur down the tree
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    // This function takes an Array, sorts it and generated the Balanced BST
    void createBST(int arr[]) {
        Arrays.sort(arr); // Sort array
        int n = arr.length;
        root = generateBST(arr, 0, n - 1);
    }

    // Get tree
    Node getRoot() {
        return root;
    }

    // Create traversals of the tree
    void createTraversals() {
        traversal.preOrder(getRoot());
        traversal.postOrder(getRoot());
        traversal.inOrder(getRoot());
    }
}
