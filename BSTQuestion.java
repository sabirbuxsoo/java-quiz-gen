import java.util.Scanner;

/**
 * This class contains the questions for Binary Search Tree (BST) 
 * Author: Sabir Buxsoo
 */
public class BSTQuestion extends AnswerHelper {
    Scanner scan;

    BSTQuestion(Scanner scan){
        this.scan = scan;
    }
    // Question 1 - This questions tests whether a student can construct a BST given
    // the Inorder and Post-Order Traversals and give the preorder traversal
    static String one(String points) {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Create Question
        String question = "Suppose you have a Binary Search Tree with In-Order Traversal " + tree.traversal.getInOrder()
                + " and Post-Order Traversal " + tree.traversal.getPostOrder()
                + ". What is the Pre-Order Traversal of the Tree?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(tree.traversal.getPreOrder()); // Generate Answers
        String questionOne = point + "\n" + question + "\n" + ans;
        // tree.clearTraversals();
        return questionOne;
    }

    // Question 2 - This questions tests whether a student can construct a BST given
    // the Inorder and preorder Traversals and give the postorder traversal
    static String two(String points) {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Create Question
        String question = "Suppose you have a Binary Search Tree with inorder traversal " + tree.traversal.getInOrder()
                + " and preorder traversal " + tree.traversal.getPreOrder()
                + ". What is the postorder traversal of the tree?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(tree.traversal.getPostOrder()); // Generate Answers
        String questionTwo = point + "\n" + question + "\n" + ans;
        // tree.clearTraversals();
        return questionTwo;
    }

    // Question 3 - This questions tests the knowledge of Insertion in a BST. The
    // student needs to be able to first construct the BST and then do the Insertion
    // and finally give the new preorder traversal
    static String three(String points) {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int insertValue = arrayGen.getInsertValue();
        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        // Inorder and PostOrder of original BST
        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        // Reset values of traversal from original BST
        tree.traversal.clearTraversals();

        // Insert Value into tree
        tree.insert(insertValue);

        // Re-Create Tree traversals with new insert Value
        tree.createTraversals();

        // Get new InOrder after Insert
        String newPreOrder = tree.traversal.getPreOrder();

        // Create Question
        String question = "Suppose you have a Binary Search Tree with inorder traversal " + orgInOrder
                + " and postorder traversal " + orgPostOrder + ". Now suppose you insert " + insertValue
                + " in the tree. What is the preorder traversal of the resulting tree after the insert?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(newPreOrder);// Generate Answers
        String questionThree = point + "\n" + question + "\n" + ans;
        return questionThree;
    }

    // Question 4 - This questions tests the knowledge of Deletion in a BST. The
    // student needs to be able to first construct the BST and then do the Deletion
    // and finally give the new preorder traversal
    static String four(String points) {
        BST tree = new BST(); // New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); // Create Random Array

        int deleteValue = arrayGen.getDeleteValue(); // Value to be deleted from the BST
        int[] arr = arrayGen.getArray(); // Get Random array

        tree.createBST(arr); // Create BST from array of values

        // Create Tree traversals
        tree.createTraversals();

        // InOrder and PostOrder of Original BST
        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        // Reset values of traversal from original BST
        tree.traversal.clearTraversals();

        tree.deleteKey(deleteValue); // Value to be deleted from BST

        // Re-Create Tree traversals with new insert Value
        tree.createTraversals();

        // Get new InOrder after Deleting element from BST
        String newPreOrder = tree.traversal.getPreOrder();

        // Generate question
        String question = "Suppose you have a Binary Search Tree with inorder traversal " + orgInOrder
                + " and postorder Traversal " + orgPostOrder + ". Now suppose you Delete " + deleteValue
                + " from the tree. What is the preorder Traversal of the resulting tree after the deletion?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(newPreOrder);// Generate Answers
        String question4 = point + "\n" + question + "\n" + ans;
        return question4;
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
        System.out.println("Select question to generate:\n1. Find preorder traversal given inorder and postorder traversals of a BST\n2. Find postorder traversal given inorder and preorder traversals of a BST\n3. Insertion of a key in a BST\n4. Deletion of a key from a BST");
        System.out.print("Enter question selection and press Enter: ");
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
