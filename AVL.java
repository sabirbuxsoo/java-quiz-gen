/**
 * The AVL class is the main AVL Tree class The class handles Insertion and
 * Deletion 
 * Author: Sabir Buxsoo 
 * Code adaptation and References:
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * https://www.geeksforgeeks.org/avl-tree-set-2-deletion/?ref=lbp
 */
class AVL {
    Traversal traversal; // Will hold an instance of the Traversal class
    Node root;

    AVL() {
        traversal = new Traversal();
    }

    // Get height of tree
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Find maximum value between two integers
    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    // Right rotate subtree rooted with y
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Do rotation
        x.right = y;
        y.left = T2;

        // Update height
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return updated root
        return x;
    }

    // Left rotate subtree rooted with x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Do rotation
        y.left = x;
        x.right = T2;

        // Update height
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return updated root
        return y;
    }

    // Get Balance factor of node N
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int data) {
        // First, we do the normal BST rotation
        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        // Update height of the ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether this node
        // became unbalanced
        int balance = getBalance(node);

        // If Unbalanced

        // Left Left
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right Right
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left Right
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return unmodified node pointer
        return node;
    }

    /*
     * Given a non-empty binary search tree, return the node with minimum data value
     * found in that tree. Note that the entire tree does not need to be searched.
     */
    private Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int data) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the data to be deleted is smaller than
        // the root's data, then it lies in left subtree
        if (data < root.data)
            root.left = deleteNode(root.left, data);

        // If the data to be deleted is greater than the
        // root's data, then it lies in right subtree
        else if (data > root.data)
            root.right = deleteNode(root.right, data);

        // if data is same as root's data, then this is the node
        // to be deleted
        else {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // This function takes an Array, sorts it and generated the Balanced BST
    void createAVL(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
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
