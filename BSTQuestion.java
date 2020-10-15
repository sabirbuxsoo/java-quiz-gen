import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class contains the questions for Binary Search Tree (BST) Author: Sabir
 * Buxsoo
 */
public class BSTQuestion extends AnswerHelper {
    // Question 1 - This questions tests whether a student can construct a BST given
    // the Inorder and Post-Order Traversals
    static String one() {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        

        String question = "Suppose you have a Binary Search Tree with In-Order Traversal " + tree.traversal.getInOrder()
                + " and Post-Order Traversal " + tree.traversal.getPostOrder()
                + ". What is the Pre-Order Traversal of the Tree?";
        String point = "Question (1 point)";
        String ans = generateAnswers(tree.traversal.getPreOrder()); // Generate Answers
        String questionOne = point + "\n" + question + "\n" + ans;
        // tree.clearTraversals();
        return questionOne;
    }

    // Question 2 - This questions tests the knowledge of Insertion in a BST. The
    // student needs to be able to first construct the BST and then do the Insertion
    // and finally give the new InOrder traversal
    static String two() {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int insertValue = arrayGen.getInsertValue();
        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        tree.traversal.clearTraversals();

        tree.insert(insertValue);

        // Re-Create Tree traversals with new insert Value
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String newInOrder = tree.traversal.getInOrder();

        String question = "Suppose you have a Binary Search Tree with In-Order Traversal " + orgInOrder
                + " and Post-Order Traversal " + orgPostOrder + ". Now suppose you insert " + insertValue
                + " in the tree. What is the in-order Traversal of the resulting tree after the insert?";
        String point = "Question (1 point)";
        String ans = generateAnswers(newInOrder);// Generate Answers
        String questionTwo = point + "\n" + question + "\n" + ans;
        return questionTwo;
    }

    // Question 3 - This questions tests the knowledge of Deletion in a BST. The
    // student needs to be able to first construct the BST and then do the Deletion
    // and finally give the new InOrder traversal
    static String three() {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int deleteValue = arrayGen.getDeleteValue();
        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        tree.traversal.clearTraversals();

        tree.deleteKey(deleteValue);
        // Re-Create Tree traversals with new insert Value
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String newInOrder = tree.traversal.getInOrder();
        System.out.println(newInOrder);

        String question = "Suppose you have a Binary Search Tree with In-Order Traversal " + orgInOrder
                + " and Post-Order Traversal " + orgPostOrder + ". Now suppose you Delete " + deleteValue
                + " from the tree. What is the in-order Traversal of the resulting tree after the deletion?";
        String point = "Question (1 point)";
        String ans = generateAnswers(newInOrder);// Generate Answers
        String questionThree = point + "\n" + question + "\n" + ans;
        return questionThree;
    }

    static void generateQuestions(int numQuestions, int selection) {
        switch (selection) {
            case 1:
                for (int i = 0; i < numQuestions; i++) {
                    System.out.println(one());
                }
                break;
            case 2:
                for (int i = 0; i < numQuestions; i++) {
                    System.out.println(two());
                }
                break;
            case 3:
                for (int i = 0; i < numQuestions; i++) {
                    System.out.println(three());
                }
                break;
            default:
                System.out.println("Wrong selection. Please try again");
                break;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Type of question to generate:\n1. Generic\n2. Insertion\n3. Deletion:");

        System.out.print("Enter your selection and press Enter: ");
        int selection = sc.nextInt();
        System.out.print("Enter number of questions you want generated and press Enter:");
        int numQuestions = sc.nextInt();
        generateQuestions(numQuestions, selection);
    }

}
