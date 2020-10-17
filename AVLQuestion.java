import java.util.Scanner;

/**
 * This class contains the questions for AVL Tree 
 * Author: Sabir Buxsoo
 */
public class AVLQuestion extends AnswerHelper {
    Scanner scan;
    AVLQuestion(Scanner scan){
        this.scan = scan;
    }
    // Question 1 - This questions tests whether a student can construct an AVL given
    // the inorder and postorder traversals and give the preorder traversal
    static String one(String points) {
        AVL tree = new AVL(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createAVL(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Create Question
        String question = "Suppose you have an AVL Tree with inorder traversal " + tree.traversal.getInOrder()
                + " and postorder traversal " + tree.traversal.getPostOrder()
                + ". What is the preorder traversal of the tree?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(tree.traversal.getPreOrder()); // Generate Answers
        String questionOne = point + "\n" + question + "\n" + ans;

        return questionOne;
    }

    // Question 2 - This questions tests whether a student can construct an AVL given
    // the inorder and preorder Traversals and give the postorder traversal
    static String two(String points) {
        AVL tree = new AVL(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createAVL(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Create Question
        String question = "Suppose you have an AVL Tree with inorder traversal " + tree.traversal.getInOrder()
                + " and preorder traversal " + tree.traversal.getPreOrder()
                + ". What is the postorder traversal of the tree?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(tree.traversal.getPostOrder()); // Generate Answers
        String questionTwo = point + "\n" + question + "\n" + ans;

        return questionTwo;
    }

    // Question 3 - This question tests the knowledge of Insertion in an AVL. The
    // student needs to be able to first construct the AVL and then do the Insertion
    // and finally give the new preorder traversal
    static String three(String points) {
        AVL tree = new AVL(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int insertValue = arrayGen.getInsertValue();

        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createAVL(arr); // Create AVL from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Inorder and PostOrder of original AVL
        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        // Insert Value into tree
        tree.root = tree.insert(tree.root, insertValue);

        // Clear Traversals
        tree.traversal.clearTraversals();

        // Create New Tree traversals
        tree.createTraversals();

        // Get new PreOrder after Insert
        String newPreOrder = tree.traversal.getPreOrder();

        // Create Question
        String question = "Suppose you have an AVL Tree with Inorder traversal " + orgInOrder
                + " and Postorder traversal " + orgPostOrder + ". Now suppose you insert " + insertValue
                + " in the tree. What is the Preorder Traversal of the resulting tree after the insert?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(newPreOrder);// Generate Answers
        String questionThree = point + "\n" + question + "\n" + ans;
        return questionThree;
    }

    // Question 4 - This question tests the knowledge of Deletion from an AVL tree. The
    // student needs to be able to first construct the AVL tree and then do the Deletion
    // and finally give the new preorder traversal
    static String four(String points) {
        AVL tree = new AVL(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int deleteValue = arrayGen.getDeleteValue(); // Value to be deleted from the AVL
        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createAVL(arr); // Create AVL from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Inorder and PostOrder of original AVL
        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        // Delete element from tree
        tree.root = tree.deleteNode(tree.root, deleteValue);

        // Clear Traversals
        tree.traversal.clearTraversals();

        // Create New Tree traversals
        tree.createTraversals();

        // Get new PreOrder after deletion
        String newPreOrder = tree.traversal.getPreOrder();

        // Generate question
        String question = "Suppose you have an AVL Tree with Inorder traversal " + orgInOrder
                + " and Postorder traversal " + orgPostOrder + ". Now suppose you Delete " + deleteValue
                + " from the tree. What is the Preorder Traversal of the resulting tree after the deletion?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(newPreOrder);// Generate Answers
        String questionFour = point + "\n" + question + "\n" + ans;
        return questionFour;
    }

    // Method to Generate questions from user selection. Method also takes number of
    // questions to be generated
    static void generateQuestions(int numQuestions, int selection, String fileName, String points) {
        String finalAnswers = "";
        switch (selection) {
            case 1:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += one(points);
                }
                break;
            case 2:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += two(points);
                }
                break;
            case 3:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += three(points);
                }
                break;
            case 4:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += four(points);
                }
                break;
            default:
                System.out.println("Wrong selection. Please try again");
                break;
        }
        writeAnswers(fileName, finalAnswers);
    }

    void promptUser(){
        System.out.println("Select question to generate:\n1. Find preorder traversal given inorder and postorder traversals of an AVL Tree\n2. Find postorder traversal given inorder and preorder traversals of an AVL Tree\n3. Insertion of a key in an AVL Tree\n4. Deletion of a key from an AVL Tree");
        System.out.print("Enter your selection and press Enter: ");
        int selection = scan.nextInt();
        System.out.print("Enter number of questions you want generated and press Enter: ");
        int numQuestions = scan.nextInt();
        System.out.print("Enter number of points for each question: ");
        String points = scan.next();
        System.out.print("Enter output file name to save questions (do not add extension): ");
        String fileName = scan.next();
        generateQuestions(numQuestions, selection, fileName, points);
    }
}
