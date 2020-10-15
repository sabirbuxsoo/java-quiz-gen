import java.util.Arrays;
import java.util.Collections;

/**
 * This class contains the questions for Binary Search Tree (BST) Author: Sabir
 * Buxsoo
 */
public class BSTQuestion {
    //Method to return the Binary Search Tree. In this case, we are creating a Balanced Binary Search Tree for more optimal performace
    
    static String randomizeAnswer(String ans) {
        String[] arr = ans.split(" ");

        int arraySize = arr.length;

        String firstElement = arr[0];
        String lastElement = arr[arraySize - 1];

        String[] arr2 = new String[arraySize - 2];

        String arr3[] = new String[arraySize];

        arr3[0] = firstElement;
        for (int i = 0; i < arraySize - 2; i++) {
            arr2[i] = arr[i + 1];
        }

        Collections.shuffle(Arrays.asList(arr2));

        for (int j = 0; j < arr2.length; j++) {
            arr3[j + 1] = arr2[j];
        }
        arr3[arraySize - 1] = lastElement;

        return String.join(" ", arr3);
        
    }

    static String[] generateAnswers(String ans) {
        String[] answers = new String[5];
        answers[0] = ans;
        answers[4] = "None of the answers are correct";

        for (int x = 0; x < 3; x++) {
            while (true) {
                String randomAns = randomizeAnswer(ans);
                if (Arrays.stream(answers).anyMatch(randomAns::equals)) {
                    continue;
                } else {
                    answers[x+1] = randomAns;
                    break;
                }
            }
        }

        return answers;
    }

    // Question 1 - This questions tests whether a student can construct a BST given
    // the Inorder and Post-Order Traversals
    static String one() {
        BST tree = new BST(); //New Binary Search Tree Object
    
        ArrayGenerator arrayGen = new ArrayGenerator(); //Create Random Array
        int[] arr = arrayGen.getArray(); //Get Random array

        tree.createBST(arr); //Create BST from array of values

        //Create Tree traversals
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String[] ans = generateAnswers(tree.traversal.getPreOrder()); //Generate Answers
        
        String question = "Suppose you have a Binary Search Tree with In-Order Traversal " + tree.traversal.getInOrder()
                + " and Post-Order Traversal " + tree.traversal.getPostOrder() + ". What is the Pre-Order Traversal of the Tree?";
        String point = "Question (1 point)";
        String ansA = "* A. " + ans[0];
        String ansB = "B. " + ans[1];
        String ansC = "C. " + ans[2];
        String ansD = "D. " + ans[3];
        String ansE = "E. " + ans[4];
        String randomize = "#randomize";
        String questionOne = point + "\n" + question + "\n" + ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize;
        // tree.clearTraversals();
        return questionOne;
    }

    //Question 2 - This questions tests the knowledge of Insertion in a BST. The student needs to be able to first construct the BST and then do the Insertion and finally give the new InOrder traversal
    static  String two(){
        BST tree = new BST(); //New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); //Create Random Array

        int insertValue = arrayGen.getInsertValue();
        int[] arr = arrayGen.getArray(); //Get Random array

        tree.createBST(arr); //Create BST from array of values

        //Create Tree traversals
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        tree.traversal.clearTraversals();

        tree.insert(insertValue);

        //Re-Create Tree traversals with new insert Value
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String newInOrder = tree.traversal.getInOrder();

        String[] ans = generateAnswers(newInOrder);//Generate Answers

        String question = "Suppose you have a Binary Search Tree with In-Order Traversal " + orgInOrder +" and Post-Order Traversal " + orgPostOrder + ". Now suppose you insert " + insertValue + " in the tree. What is the in-order Traversal of the resulting tree after the insert?";
        String point = "Question (1 point)";
        String ansA = "* A. " + ans[0];
        String ansB = "B. " + ans[1];
        String ansC = "C. " + ans[2];
        String ansD = "D. " + ans[3];
        String ansE = "E. " + ans[4];
        String randomize = "#randomize";
        String questionTwo = point + "\n" + question + "\n" + ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize;
        return questionTwo;
    }

    //Question 3 - This questions tests the knowledge of Deletion in a BST. The student needs to be able to first construct the BST and then do the Deletion and finally give the new InOrder traversal
    static  String three(){
        BST tree = new BST(); //New Binary Search Tree Object
        ArrayGenerator arrayGen = new ArrayGenerator(); //Create Random Array

        int deleteValue = arrayGen.getDeleteValue();
        int[] arr = arrayGen.getArray(); //Get Random array

        tree.createBST(arr); //Create BST from array of values

        //Create Tree traversals
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String orgInOrder = tree.traversal.getInOrder();
        String orgPostOrder = tree.traversal.getPostOrder();

        tree.traversal.clearTraversals();
        
        tree.deleteKey(deleteValue);
        //Re-Create Tree traversals with new insert Value
        tree.traversal.preOrder(tree.getRoot());
        tree.traversal.postOrder(tree.getRoot());
        tree.traversal.inOrder(tree.getRoot());

        String newInOrder = tree.traversal.getInOrder();

        String[] ans = generateAnswers(newInOrder);//Generate Answers

        String question = "Suppose you have a Binary Search Tree with In-Order Traversal "+ orgInOrder +" and Post-Order Traversal "+ orgPostOrder +". Now suppose you Delete "+ deleteValue + " from the tree. What is the in-order Traversal of the resulting tree after the deletion?";
        String point = "Question (1 point)";
        String ansA = "* A. " + ans[0];
        String ansB = "B. " + ans[1];
        String ansC = "C. " + ans[2];
        String ansD = "D. " + ans[3];
        String ansE = "E. " + ans[4];
        String randomize = "#randomize";
        String questionThree = point + "\n" + question + "\n" + ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize;
        return questionThree;
    }

    public static void main(String args[]){
        System.out.println(one());
        System.out.println(two());
        System.out.println(three());
    }
    
}
